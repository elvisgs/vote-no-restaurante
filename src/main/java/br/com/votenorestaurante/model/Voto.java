package br.com.votenorestaurante.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voto extends Entidade {

    @ManyToOne
    private Votante votante;

    @Embedded
    private Duelo duelo;

    @ManyToOne
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
