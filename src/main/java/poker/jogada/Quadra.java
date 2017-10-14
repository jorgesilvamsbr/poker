package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;

public class Quadra implements Jogada{

    private long quantidadeDeCartasIguais;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        cartas.forEach(cartaSendoComparada -> {
            if(cartas.stream().anyMatch(carta -> cartaSendoComparada.getValor().equals(carta.getValor()))){
                quantidadeDeCartasIguais++;
            }
        });
        return quantidadeDeCartasIguais == 4 ? TipoDaJogada.QUADRA : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
