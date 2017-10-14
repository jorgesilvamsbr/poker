package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;

public class Trinca implements Jogada {
    private int quantidadeDePar = 0;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        cartas.forEach(cartaSendoComparada -> {
            if(cartas.stream().anyMatch(carta -> cartaSendoComparada.getValor().equals(carta.getValor()))){
                quantidadeDePar++;
            }
        });
        return quantidadeDePar == 3 ? TipoDaJogada.TRINCA : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
