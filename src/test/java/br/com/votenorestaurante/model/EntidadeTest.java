package br.com.votenorestaurante.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EntidadeTest {

    @Test
    public void entidadesComMesmoIdDevemSerIguais() {
        Restaurante restaurante1 = new Restaurante();
        restaurante1.setId(1);
        Restaurante restaurante2 = new Restaurante();
        restaurante2.setId(1);

        assertThat(restaurante1).isEqualTo(restaurante2);
    }

    @Test
    public void entidadesComIdsDiferentesDevemSerDiferentes() {
        Restaurante restaurante1 = new Restaurante();
        restaurante1.setId(1);
        Restaurante restaurante2 = new Restaurante();
        restaurante2.setId(2);

        assertThat(restaurante1).isNotEqualTo(restaurante2);
    }
}