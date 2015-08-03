package br.com.votenorestaurante.dao;

import br.com.votenorestaurante.model.Duelo;
import br.com.votenorestaurante.model.Restaurante;

import java.util.List;

public interface RestauranteDao {

    void salvar(Restaurante restaurante);
    List<Restaurante> todos();
    List<Duelo> duelosPossiveis();
    void refresh(Restaurante restaurante);
}
