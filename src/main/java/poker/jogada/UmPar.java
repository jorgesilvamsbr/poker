package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;

public class UmPar implements Jogada {

    private boolean possuiUmPar;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        cartas.forEach(cartaSendoComparada -> {
            possuiUmPar = cartas.stream().anyMatch(carta -> cartaSendoComparada.getValor().equals(carta.getValor()));
        });
        return possuiUmPar ? TipoDaJogada.UM_PAR : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
