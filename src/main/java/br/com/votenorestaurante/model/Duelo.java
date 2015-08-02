package br.com.votenorestaurante.model;

public class Duelo {

    private Restaurante restaurante1, restaurante2;

    protected Duelo() {}

    public Duelo(Restaurante restaurante1, Restaurante restaurante2) {
        if (restaurante1 == null) throw new IllegalArgumentException("restaurante1 nao pode ser nulo");
        if (restaurante2 == null) throw new IllegalArgumentException("restaurante2 nao pode ser nulo");

        this.restaurante1 = restaurante1;
        this.restaurante2 = restaurante2;
    }

    public Restaurante getRestaurante1() {
        return restaurante1;
    }

    public void setRestaurante1(Restaurante restaurante1) {
        this.restaurante1 = restaurante1;
    }

    public Restaurante getRestaurante2() {
        return restaurante2;
    }

    public void setRestaurante2(Restaurante restaurante2) {
        this.restaurante2 = restaurante2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Duelo duelo = (Duelo) o;

        if (!restaurante1.equals(duelo.restaurante1)) return false;
        return restaurante2.equals(duelo.restaurante2);

    }

    @Override
    public int hashCode() {
        int result = restaurante1.hashCode();
        result = 31 * result + restaurante2.hashCode();
        return result;
    }
}
