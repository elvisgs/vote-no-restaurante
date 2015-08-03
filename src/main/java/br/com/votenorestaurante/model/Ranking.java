package br.com.votenorestaurante.model;

import java.util.*;

public class Ranking implements Iterable<ItemRanking> {

    private List<ItemRanking> itens;

    public Ranking(Collection<Voto> votos) {
        if (votos == null) throw new IllegalArgumentException("votos nao pode ser nulo");

        itens = new ArrayList<>();

        totalizarPontos(votos);
    }

    private void totalizarPontos(Collection<Voto> votos) {
        votos.stream().forEach(voto -> {
            ItemRanking item = new ItemRanking(voto.getDuelo());

            if (!itens.contains(item))
                itens.add(item);
            else
                item = itens.get(itens.indexOf(item));

            item.atualizarPontuacao(voto.getVencedor());
        });
    }

    public List<ItemRanking> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public Iterator<ItemRanking> iterator() {
        return itens.iterator();
    }
}
