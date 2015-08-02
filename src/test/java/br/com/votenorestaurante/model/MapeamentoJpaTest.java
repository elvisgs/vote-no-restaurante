package br.com.votenorestaurante.model;

import org.junit.Test;

import javax.persistence.Persistence;

public class MapeamentoJpaTest {

    @Test
    public void mapeamentoDeveEstarCorreto() {
        Persistence.createEntityManagerFactory("default");
    }
}
