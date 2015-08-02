package br.com.votenorestaurante.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Voto voto = (Voto) o;

        if (!votante.equals(voto.votante)) return false;
        return duelo.equals(voto.duelo);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + votante.hashCode();
        result = 31 * result + duelo.hashCode();
        return result;
    }
}
