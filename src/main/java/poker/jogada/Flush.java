package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;

public class Flush implements Jogada{
    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        Carta primeiraCarta = cartas.get(0);
        boolean todasSaoDoMesmoNaipe = cartas.stream().allMatch(carta -> primeiraCarta.getNaipe().equals(carta.getNaipe()));
        return todasSaoDoMesmoNaipe ? TipoDaJogada.FLUSH : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        return null;
    }
}
