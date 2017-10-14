package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;

public class DoisPares implements Jogada {
    private int quantidadeDePar;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        for(int i = 0; i < cartas.size() - 1; i++){
            quantidadeDePar = 0;
            cartas.forEach(cartaSendoComparada -> {
                if (cartas.stream().anyMatch(carta -> cartaSendoComparada.getValor().equals(carta.getValor()))) {
                    quantidadeDePar++;
                }
            });
        }
        return quantidadeDePar == 2 ? TipoDaJogada.DOIS_PARES : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
