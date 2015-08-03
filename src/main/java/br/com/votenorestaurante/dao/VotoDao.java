package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.model.Votante;
import br.com.votenorestaurante.model.Voto;

import java.util.List;

public interface VotoDao {

    List<Voto> doVotante(Votante votante);
    List<Voto> todos();
}
