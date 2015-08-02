package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.TestConfig;
import br.com.votenorestaurante.model.Duelo;
import br.com.votenorestaurante.model.Restaurante;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class DefaultRestauranteDaoTest {

    @Autowired
    private EntityManager em;

    private RestauranteDao dao;

    @Before
    public void inicializar() throws Exception {
        dao = new DefaultRestauranteDao(em);

        em.getTransaction().begin();
        em.createNativeQuery("delete from restaurante").executeUpdate();
        em.createNativeQuery("insert into restaurante(nome, imagem) values ('Teste 1', 'teste1.png')").executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    public void buscaTodosRestaurantes() {
        List<Restaurante> restaurantes = dao.todos();

        assertThat(restaurantes).hasSize(1);
        assertThat(restaurantes.get(0).getNome()).isEqualTo("Teste 1");
    }

    @Test
    public void salvaUmNovoRestaurante() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Teste");
        restaurante.setImagem("teste.png");

        dao.salvar(restaurante);

        assertThat(dao.todos()).hasSize(2);
    }

    @Test
    public void geraDuelosPossiveisQuandoExistemRestaurantesCadastrados() {
        Restaurante restaurante1 = dao.todos().get(0);

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Teste 2");
        dao.salvar(restaurante2);

        Restaurante restaurante3 = new Restaurante();
        restaurante3.setNome("Teste 3");
        dao.salvar(restaurante3);

        Restaurante restaurante4 = new Restaurante();
        restaurante4.setNome("Teste 4");
        dao.salvar(restaurante4);

        List<Duelo> duelos = dao.duelosPossiveis();

        assertThat(duelos).hasSize(6).containsAll(Arrays.asList(
                new Duelo(restaurante1, restaurante2),
                new Duelo(restaurante1, restaurante3),
                new Duelo(restaurante1, restaurante4),
                new Duelo(restaurante2, restaurante3),
                new Duelo(restaurante2, restaurante4),
                new Duelo(restaurante3, restaurante4)
        ));
    }

    @Test
    public void naoGeraDuelosPossiveisQuandoNaoExistemRestaurantesCadastrados() {
        em.getTransaction().begin();
        em.createNativeQuery("delete from restaurante").executeUpdate();
        em.getTransaction().commit();

        List<Duelo> duelos = dao.duelosPossiveis();

        assertThat(duelos).isEmpty();
    }
}