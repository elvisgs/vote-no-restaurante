package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.TestConfig;
import br.com.votenorestaurante.model.Duelo;
import br.com.votenorestaurante.model.Restaurante;
import br.com.votenorestaurante.model.Votante;
import br.com.votenorestaurante.model.Voto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class DefaultVotanteDaoTest {

    @Autowired
    private EntityManager em;

    private VotanteDao dao;

    @Before
    public void inicializar() {
        dao = new DefaultVotanteDao(em);
        em.getTransaction().begin();
    }

    @After
    public void finalizar() {
        em.getTransaction().commit();
    }

    @Test
    public void salvaUmNovoVotante() {
        Votante votante = criarVotante();

        dao.salvar(votante);

        List<Votante> votantes = em.createQuery("select v from Votante v where v = :votante", Votante.class)
                .setParameter("votante", votante)
                .getResultList();
        assertThat(votantes).hasSize(1);

        limpeza(votante);
    }

    @Test
    public void salvaVotosEmCascata() {
        Votante votante = criarVotante();
        List<Voto> votos = criarVotos();
        votante.addVoto(votos.get(0));
        votante.addVoto(votos.get(1));

        dao.salvar(votante);

        List<Voto> votosSalvos = em.createQuery("select v from Voto v where v.votante = :votante", Voto.class)
                .setParameter("votante", votante)
                .getResultList();
        assertThat(votosSalvos).hasSize(2);

        limpeza(votante);
    }

    private Votante criarVotante() {
        Votante votante = new Votante();
        votante.setNome("Votante teste");
        votante.setEmail("teste@mail.com");
        return votante;
    }

    private List<Voto> criarVotos() {
        List<Restaurante> restaurantes = em.createQuery("select r from Restaurante r", Restaurante.class).getResultList();
        Duelo duelo1 = new Duelo(restaurantes.get(1), restaurantes.get(2));
        Duelo duelo2 = new Duelo(restaurantes.get(1), restaurantes.get(3));

        Voto voto1 = new Voto();
        voto1.setDuelo(duelo1);
        voto1.setVencedor(restaurantes.get(1));

        Voto voto2 = new Voto();
        voto2.setDuelo(duelo2);
        voto2.setVencedor(restaurantes.get(3));

        return asList(voto1, voto2);
    }

    private void limpeza(Votante votante) {
        em.remove(votante);
    }
}