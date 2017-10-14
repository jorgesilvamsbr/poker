package poker.jogada;

import poker.Jogador;

public class CartaAlta implements Jogada{
    @Override
    public TipoDaJogada validar(Jogador jogador) {
        return TipoDaJogada.CARTA_ALTA;
    }
}
