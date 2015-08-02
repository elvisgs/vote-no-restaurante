package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.model.Votante;

import javax.persistence.EntityManager;

public class DefaultVotanteDao extends BaseDao implements VotanteDao {

    public DefaultVotanteDao() {
        this(null);
    }

    public DefaultVotanteDao(EntityManager em) {
        super(em);
    }

    @Override
    public void salvar(Votante votante) {
        em.getTransaction().begin();
        em.persist(votante);
        em.getTransaction().commit();
    }
}
