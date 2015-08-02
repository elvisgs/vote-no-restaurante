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
    }

    @Test
    public void buscaTodosRestaurantes() {
        List<Restaurante> restaurantes = dao.todos();

        assertThat(restaurantes).hasSize(4);
    }

    @Test
    public void salvaUmNovoRestaurante() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Teste");
        restaurante.setImagem("teste.png");

        dao.salvar(restaurante);

        assertThat(dao.todos()).hasSize(5);

        em.getTransaction().begin();
        em.remove(restaurante);
        em.getTransaction().commit();

    }

    @Test
    public void geraDuelosPossiveisQuandoExistemRestaurantesCadastrados() {
        List<Restaurante> restaurantes = dao.todos();

        List<Duelo> duelos = dao.duelosPossiveis();

        assertThat(duelos).hasSize(6).containsAll(Arrays.asList(
                new Duelo(restaurantes.get(0), restaurantes.get(1)),
                new Duelo(restaurantes.get(0), restaurantes.get(2)),
                new Duelo(restaurantes.get(0), restaurantes.get(3)),
                new Duelo(restaurantes.get(1), restaurantes.get(2)),
                new Duelo(restaurantes.get(1), restaurantes.get(3)),
                new Duelo(restaurantes.get(2), restaurantes.get(3))
        ));
    }
}