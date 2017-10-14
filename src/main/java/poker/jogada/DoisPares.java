package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;

public class DoisPares implements Jogada {
    private int quantidadeDePar;
    private int contador;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        cartas.forEach(cartaSendoComparada -> {
            contador = 0;
            cartas.forEach(carta -> {
                if (cartaSendoComparada.getValor().equals(carta.getValor())){
                    contador++;
                }
            });
            if(contador == 2){
                quantidadeDePar++;
            }
        });
        return quantidadeDePar == 2 ? TipoDaJogada.DOIS_PARES : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
