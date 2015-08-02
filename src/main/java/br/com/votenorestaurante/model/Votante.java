package br.com.votenorestaurante.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Votante extends Entidade {

    private String nome;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Voto> votos;

    public Votante() {
        votos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Voto> getVotos() {
        return Collections.unmodifiableSet(votos);
    }

    public void addVoto(Voto voto) {
        if (voto == null) throw new IllegalArgumentException("voto nao pode ser nulo");

        voto.setVotante(this);
        votos.add(voto);
    }
}
