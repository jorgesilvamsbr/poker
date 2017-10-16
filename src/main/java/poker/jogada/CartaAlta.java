package poker.jogada;

import poker.Jogador;

public class CartaAlta implements Jogada {
    @Override
    public TipoDaJogada validar(Jogador jogador) {
        return TipoDaJogada.CARTA_ALTA;
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        int valorDaMaiorCartaDoJogador1 = jogador1.obterCartas().stream().mapToInt(carta -> carta.calcularOValorDaCarta()).max().getAsInt();
        int valorDaMaiorCartaDoJogador2 = jogador2.obterCartas().stream().mapToInt(carta -> carta.calcularOValorDaCarta()).max().getAsInt();
        return valorDaMaiorCartaDoJogador1 > valorDaMaiorCartaDoJogador2 ? jogador1 : jogador2;
    }
}
