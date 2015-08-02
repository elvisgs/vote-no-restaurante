package br.com.votenorestaurante.dao;

import javax.persistence.EntityManager;

public abstract class BaseDao {

    protected EntityManager em;

    public BaseDao(EntityManager em) {
        this.em = em;
    }
}
