package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;
import poker.carta.Naipe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RoyalFlush implements Jogada {
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        if(saoTodosDoMesmoNaipe(cartas) && sequenciaCorretaParaRoyalFlush(cartas)) {
            return TipoDaJogada.ROYAL_FLUSH;
        }
        return TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }

    private boolean sequenciaCorretaParaRoyalFlush(List<Carta> cartas) {
        List<String> valoresParaRoyalFlush = Arrays.asList("10", "J", "Q", "K", "A");
        return valoresParaRoyalFlush.containsAll(cartas.stream().map(c -> c.getValor()).collect(Collectors.toList()));
    }

    private boolean saoTodosDoMesmoNaipe(List<Carta> cartas) {
        Naipe naipe = cartas.get(0).getNaipe();
        return cartas.stream().allMatch(carta -> naipe.equals(carta.getNaipe()));
    }
}
