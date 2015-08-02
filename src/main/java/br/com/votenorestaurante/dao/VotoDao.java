package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.model.Votante;
import br.com.votenorestaurante.model.Voto;

import java.util.List;

public interface VotoDao {

    List<Voto> rankingDoVotante(Votante votante);
    List<Voto> rankingGeral();
}
