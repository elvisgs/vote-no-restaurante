package br.com.votenorestaurante.util;

import br.com.votenorestaurante.dao.RestauranteDao;
import br.com.votenorestaurante.dao.VotanteDao;
import br.com.votenorestaurante.model.Duelo;
import br.com.votenorestaurante.model.Restaurante;
import br.com.votenorestaurante.model.Voto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VotacaoTest {

    @Mock
    private RestauranteDao restauranteDao;

    @Mock
    private VotanteDao votanteDao;

    private Votacao votacao;
    private List<Duelo> duelos;

    @Before
    public void inicializacao() {
        duelos = asList(
                new Duelo(new Restaurante("A", ""), new Restaurante("B", "")),
                new Duelo(new Restaurante("A", ""), new Restaurante("C", "")),
                new Duelo(new Restaurante("B", ""), new Restaurante("C", ""))
        );

        when(restauranteDao.duelosPossiveis()).thenReturn(duelos);

        votacao = new Votacao(restauranteDao, votanteDao);
    }

    @Test
    public void aoIniciarDuelosRestantesDeveSerIgualADuelosPossiveis() {
        List<Duelo> duelosRestantes = votacao.getDuelosRestantes();

        assertThat(duelosRestantes).hasSameElementsAs(restauranteDao.duelosPossiveis());
    }

    @Test
    public void aoIniciarVotanteNaoDeveSerNulo() {
        assertThat(votacao.getVotante()).isNotNull();
    }

    @Test
    public void ofereceProximoDueloSeExistir() {
        Optional<Duelo> duelo = votacao.proximoDuelo();

        assertThat(duelo.isPresent()).isTrue();
    }

    @Test
    public void naoOfereceProximoDueloSeNaoExistir() {
        votacao.proximoDuelo();
        votacao.proximoDuelo();
        votacao.proximoDuelo();
        Optional<Duelo> duelo = votacao.proximoDuelo();

        assertThat(duelo.isPresent()).isFalse();
    }

    @Test
    public void atualizaDueloAtualAoOferecerDuelo() {
        Optional<Duelo> proximoDuelo = votacao.proximoDuelo();

        assertThat(votacao.getDueloAtual()).isEqualTo(proximoDuelo);
    }

    @Test
    public void adicionaVotoAListaDeVotosDoVotante() {
        votacao.proximoDuelo();

        votacao.votar(duelos.get(1).getRestaurante1());

        Set<Voto> votos = votacao.getVotante().getVotos();
        assertThat(votos).isNotEmpty();
    }

    @Test
    public void aoFinalizarSalvaVotanteESeusVotos() {
        votacao.finalizar();

        verify(votanteDao, only()).salvar(votacao.getVotante());
    }

    @Test
    public void aoReiniciarAtualizaDuelosRestantes() {
        votacao.proximoDuelo();
        votacao.proximoDuelo();

        votacao.reiniciar();

        assertThat(votacao.getDuelosRestantes()).containsAll(duelos);
    }
}