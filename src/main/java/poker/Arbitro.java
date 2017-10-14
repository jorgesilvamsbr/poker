package poker;

import poker.carta.Carta;
import poker.jogada.*;

import java.util.HashMap;

public class Arbitro {
    private static final HashMap<TipoDaJogada, Class<? extends Jogada>> mapaDeJogadas = new HashMap<>();

    static {
        mapaDeJogadas.put(TipoDaJogada.CARTA_ALTA, CartaAlta.class);
        mapaDeJogadas.put(TipoDaJogada.UM_PAR, UmPar.class);
        mapaDeJogadas.put(TipoDaJogada.DOIS_PARES, DoisPares.class);
        mapaDeJogadas.put(TipoDaJogada.TRINCA, Trinca.class);
        mapaDeJogadas.put(TipoDaJogada.STRAIGHT, Straight.class);
        mapaDeJogadas.put(TipoDaJogada.FLUSH, Flush.class);
        mapaDeJogadas.put(TipoDaJogada.FULL_HOUSE, FullHouse.class);
        mapaDeJogadas.put(TipoDaJogada.QUADRA, Quadra.class);
        mapaDeJogadas.put(TipoDaJogada.STRAIGHT_FLUSH, StraightFlush.class);
        mapaDeJogadas.put(TipoDaJogada.ROYAL_FLUSH, RoyalFlush.class);
    }

    private TipoDaJogada jogadaDoJogador1 = TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    private TipoDaJogada jogadaDoJogador2 = TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;

    public Jogador obterVencedor(final Jogador jogador1, final Jogador jogador2) throws IllegalAccessException, InstantiationException {
        for (TipoDaJogada tipoDaJogada : TipoDaJogada.obterTodas()) {
            Jogada jogada = mapaDeJogadas.get(tipoDaJogada).newInstance();
            jogadaDoJogador1 = jogada.validar(jogador1).ehSemJogada() ? jogadaDoJogador1 : jogada.validar(jogador1);
            jogadaDoJogador2 = jogada.validar(jogador2).ehSemJogada() ? jogadaDoJogador2 : jogada.validar(jogador2);
        }
        return jogadaDoJogador1.ehMaiorQue(jogadaDoJogador2) ? jogador1 : jogador2;
    }
}