package br.com.votenorestaurante.util;

import br.com.votenorestaurante.dao.RestauranteDao;
import br.com.votenorestaurante.dao.VotanteDao;
import br.com.votenorestaurante.model.Duelo;
import br.com.votenorestaurante.model.Restaurante;
import br.com.votenorestaurante.model.Votante;
import br.com.votenorestaurante.model.Voto;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import static java.util.stream.Collectors.toList;

@SessionScoped
public class Votacao implements Serializable {

    private final RestauranteDao restauranteDao;
    private final VotanteDao votanteDao;
    private Votante votante = new Votante();
    private List<Duelo> duelosPossiveis;
    private Stack<Duelo> duelosRestantes = new Stack<>();
    private Optional<Duelo> dueloAtual;

    public Votacao() {
        this(null, null);
    }

    @Inject
    public Votacao(RestauranteDao restauranteDao, VotanteDao votanteDao) {
        this.restauranteDao = restauranteDao;
        this.votanteDao = votanteDao;
        if (restauranteDao != null) {
            duelosPossiveis = restauranteDao.duelosPossiveis();
            carregarDuelosRestantes();
        }
    }

    private void carregarDuelosRestantes() {
        duelosPossiveis.stream().forEach(duelosRestantes::add);
    }

    public Votante getVotante() {
        return votante;
    }

    public List<Duelo> getDuelosRestantes() {
        return duelosRestantes.stream().collect(toList());
    }

    public Optional<Duelo> getDueloAtual() {
        return dueloAtual;
    }

    public Optional<Duelo> proximoDuelo() {
        if (duelosRestantes.empty()) {
            dueloAtual = Optional.empty();
            return Optional.empty();
        }

        dueloAtual = Optional.of(duelosRestantes.pop());
        return dueloAtual;
    }

    public void votar(Restaurante restaurante) {
        Voto voto = new Voto();
        voto.setDuelo(dueloAtual.get());
        restauranteDao.refresh(restaurante);
        voto.setVencedor(restaurante);
        votante.addVoto(voto);
    }

    public void finalizar() {
        votanteDao.salvar(votante);
    }

    public void reiniciar() {
        carregarDuelosRestantes();
        votante = new Votante();
    }
}
