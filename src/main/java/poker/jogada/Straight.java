package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;
import java.util.stream.Collectors;

public class Straight implements Jogada{

    private boolean ehConsecutivo = true;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        List<Carta> cartasOrdenadas = cartas.stream().sorted((c1, c2) -> c2.calcularOValorDaCarta().compareTo(c1.calcularOValorDaCarta())).collect(Collectors.toList());
        for(int i = 0; i < cartasOrdenadas.size() - 1; i++){
            if(!(cartasOrdenadas.get(i).obterValorConsecutivo() == cartasOrdenadas.get(i+1).getValor())){
                ehConsecutivo = false;
                break;
            }
        }
        return ehConsecutivo ? TipoDaJogada.STRAIGHT : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
