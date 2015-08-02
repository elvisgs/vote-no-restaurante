package br.com.votenorestaurante.model;

public class Voto extends Entidade {

    private Votante votante;
    private Duelo duelo;
    private Restaurante vencedor;

    public Votante getVotante() {
        return votante;
    }

    public void setVotante(Votante votante) {
        this.votante = votante;
    }

    public Duelo getDuelo() {
        return duelo;
    }

    public void setDuelo(Duelo duelo) {
        this.duelo = duelo;
    }

    public Restaurante getVencedor() {
        return vencedor;
    }

    public void setVencedor(Restaurante vencedor) {
        this.vencedor = vencedor;
    }
}
