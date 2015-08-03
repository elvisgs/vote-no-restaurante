package br.com.votenorestaurante.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemRankingTest {

    @Test
    public void atualizaPontuacao() {
        Restaurante r1 = new Restaurante();
        r1.setId(1);
        Restaurante r2 = new Restaurante();
        r2.setId(2);
        Duelo duelo = new Duelo(r1, r2);
        ItemRanking item = new ItemRanking(duelo);

        item.atualizarPontuacao(r1);
        item.atualizarPontuacao(r1);
        item.atualizarPontuacao(r1);
        item.atualizarPontuacao(r2);
        item.atualizarPontuacao(r2);

        assertThat(item.getPontosRestaurante1()).isEqualTo(3);
        assertThat(item.getPontosRestaurante2()).isEqualTo(2);
    }
}