package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.model.Duelo;
import br.com.votenorestaurante.model.Restaurante;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultRestauranteDao extends BaseDao implements RestauranteDao, Serializable {

    public DefaultRestauranteDao() {
        this(null);
    }

    @Inject
    public DefaultRestauranteDao(EntityManager em) {
        super(em);
    }

    @Override
    public void salvar(Restaurante restaurante) {
        em.getTransaction().begin();
        em.persist(restaurante);
        em.getTransaction().commit();
    }

    @Override
    public List<Restaurante> todos() {
        return em.createQuery("select r from Restaurante r", Restaurante.class).getResultList();
    }

    @Override
    public List<Duelo> duelosPossiveis() {
        List<Restaurante> restaurantes = todos();
        List<Duelo> duelos = new ArrayList<>();

        for (int i = 0; i < restaurantes.size() - 1; i++) {
            for (int j = i + 1; j < restaurantes.size(); j++) {
                Duelo duelo = new Duelo(restaurantes.get(i), restaurantes.get(j));
                duelos.add(duelo);
            }
        }

        Collections.shuffle(duelos);
        return duelos;
    }

    @Override
    public void refresh(Restaurante restaurante) {
        em.unwrap(Session.class).refresh(restaurante);
    }
}
