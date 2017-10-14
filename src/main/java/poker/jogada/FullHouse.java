package poker.jogada;

import poker.Jogador;

public class FullHouse implements Jogada {

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        return TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
