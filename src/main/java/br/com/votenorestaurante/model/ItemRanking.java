package br.com.votenorestaurante.model;

public class ItemRanking {

    private Duelo duelo;
    private int pontosRestaurante1, pontosRestaurante2;

    public ItemRanking(Duelo duelo) {
        if (duelo == null) throw new IllegalArgumentException("duelo nao pode ser nulo");

        this.duelo = duelo;
    }

    public Duelo getDuelo() {
        return duelo;
    }

    public int getPontosRestaurante1() {
        return pontosRestaurante1;
    }

    public int getPontosRestaurante2() {
        return pontosRestaurante2;
    }

    public void atualizarPontuacao(Restaurante restaurante) {
        if (restaurante == duelo.getRestaurante1())
            pontosRestaurante1++;

        if (restaurante == duelo.getRestaurante2())
            pontosRestaurante2++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemRanking that = (ItemRanking) o;

        return duelo.equals(that.duelo);

    }

    @Override
    public int hashCode() {
        return duelo.hashCode();
    }
}
