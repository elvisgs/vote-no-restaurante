package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.TestConfig;
import br.com.votenorestaurante.model.Votante;
import br.com.votenorestaurante.model.Voto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class DefaultVotoDaoTest {

    @Autowired
    private EntityManager em;

    private VotoDao dao;

    @Before
    public void inicializar() {
        dao = new DefaultVotoDao(em);
    }

    @Test
    public void buscaRankingDeUmVotante() {
        Votante votante = em.createQuery("select v from Votante v where v.id = 1", Votante.class).getSingleResult();

        List<Voto> ranking = dao.rankingDoVotante(votante);

        assertThat(ranking).hasSize(3);
    }

    @Test
    public void buscaRankingGeral() {
        List<Voto> ranking = dao.rankingGeral();

        assertThat(ranking).hasSize(6);
    }
}