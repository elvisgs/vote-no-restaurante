package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.model.Votante;
import br.com.votenorestaurante.model.Voto;

import javax.persistence.EntityManager;
import java.util.List;

public class DefaultVotoDao extends BaseDao implements VotoDao {

    public DefaultVotoDao() {
        this(null);
    }

    public DefaultVotoDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Voto> rankingDoVotante(Votante votante) {
        return em.createQuery("select v from Voto v where v.votante = :votante", Voto.class)
                .setParameter("votante", votante)
                .getResultList();
    }

    @Override
    public List<Voto> rankingGeral() {
        return em.createQuery("select v from Voto v", Voto.class).getResultList();
    }
}
