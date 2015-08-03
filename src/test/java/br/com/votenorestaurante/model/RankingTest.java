package br.com.votenorestaurante.model;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @Test
    public void naoPossuiDuelosDuplicados() {
        Ranking ranking = new Ranking(criarVotos());

        assertThat(ranking.getItens()).hasSize(1);
    }

    @Test
    public void totalizaPontuacaoDosDuelos() {
        Ranking ranking = new Ranking(criarVotos());

        ItemRanking item = ranking.getItens().iterator().next();

        assertThat(item.getPontosRestaurante1()).isEqualTo(2);
        assertThat(item.getPontosRestaurante2()).isEqualTo(1);
    }

    private List<Voto> criarVotos() {
        Restaurante r1 = new Restaurante();
        r1.setId(1);
        Restaurante r2 = new Restaurante();
        r2.setId(2);

        Duelo duelo1 = new Duelo(r1, r2);
        Duelo duelo2 = new Duelo(r1, r2);
        Duelo duelo3 = new Duelo(r1, r2);

        Voto voto1 = new Voto();
        voto1.setDuelo(duelo1);
        voto1.setVencedor(r1);
        Voto voto2 = new Voto();
        voto2.setDuelo(duelo2);
        voto2.setVencedor(r2);
        Voto voto3 = new Voto();
        voto3.setDuelo(duelo3);
        voto3.setVencedor(r1);

        return asList(voto1, voto2, voto3);
    }
}