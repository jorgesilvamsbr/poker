package poker.jogada;

import poker.Jogador;

public class FullHouse implements Jogada {

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        Trinca jogadaTrinca = new Trinca();
        UmPar jogadaUmPar = new UmPar();
        return jogadaTrinca.validar(jogador).isTrinca() && jogadaUmPar.validar(jogador).isUmPar() ? TipoDaJogada.FULL_HOUSE : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        return null;
    }
}