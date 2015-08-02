package br.com.votenorestaurante.model;

public abstract class Entidade {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entidade that = (Entidade) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
