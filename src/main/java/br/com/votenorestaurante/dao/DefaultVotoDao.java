package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.model.Votante;
import br.com.votenorestaurante.model.Voto;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class DefaultVotoDao extends BaseDao implements VotoDao, Serializable {

    public DefaultVotoDao() {
        this(null);
    }

    @Inject
    public DefaultVotoDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Voto> doVotante(Votante votante) {
        return em.createQuery("select v from Voto v where v.votante = :votante", Voto.class)
                .setParameter("votante", votante)
                .getResultList();
    }

    @Override
    public List<Voto> todos() {
        return em.createQuery("select v from Voto v", Voto.class).getResultList();
    }
}
