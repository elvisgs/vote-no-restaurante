package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.model.Votante;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class DefaultVotanteDao extends BaseDao implements VotanteDao, Serializable {

    public DefaultVotanteDao() {
        this(null);
    }

    @Inject
    public DefaultVotanteDao(EntityManager em) {
        super(em);
    }

    @Override
    public void salvar(Votante votante) {
        em.persist(votante);
    }
}
