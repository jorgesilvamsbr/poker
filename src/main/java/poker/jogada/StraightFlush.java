package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;
import java.util.stream.Collectors;

public class StraightFlush implements Jogada{

    private boolean ehConsecutivo = true;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        Carta primeiraCarta = cartas.get(0);
        if(cartas.stream().allMatch(carta -> primeiraCarta.getNaipe().equals(carta.getNaipe()))){
            List<Carta> cartasOrdenadas = cartas.stream().sorted((c1, c2) -> c2.calcularOValorDaCarta().compareTo(c1.calcularOValorDaCarta())).collect(Collectors.toList());
            for(int i = 0; i < cartasOrdenadas.size() - 1; i++){
                if(!(cartasOrdenadas.get(i).obterValorConsecutivo() == cartasOrdenadas.get(i+1).getValor())){
                    ehConsecutivo = false;
                    break;
                }
            }
            return ehConsecutivo ? TipoDaJogada.STRAIGHT_FLUSH : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
        }
        return TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        return null;
    }
}
