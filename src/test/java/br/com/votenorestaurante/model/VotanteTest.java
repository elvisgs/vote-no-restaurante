package br.com.votenorestaurante.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

public class VotanteTest {

    @Test
    public void listaDeVotosDeveEstarVaziaInicialmente() {
        Votante votante = new Votante();

        assertThat(votante.getVotos()).isNotNull().isEmpty();
    }

    @Test
    public void lancaExcecaoAoAdicionarVotoNulo() {
        try {
            new Votante().addVoto(null);
            failBecauseExceptionWasNotThrown(IllegalArgumentException.class);
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void associaVotanteComOVotoAdicionado() {
        Votante votante = new Votante();
        Voto voto = new Voto();

        votante.addVoto(voto);

        assertThat(voto.getVotante()).isEqualTo(votante);
    }
}