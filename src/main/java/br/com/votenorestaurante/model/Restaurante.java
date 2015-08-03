package br.com.votenorestaurante.model;

import javax.persistence.Entity;

@Entity
public class Restaurante extends Entidade {

    private String nome;
    private String imagem;

    public Restaurante() {
    }

    public Restaurante(String nome, String imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return nome;
    }
}
