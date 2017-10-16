package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;
import java.util.stream.Collectors;

public class Flush implements Jogada{
    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        return todasAsCartasSaoDoMesmoNaipe(cartas) ? TipoDaJogada.FLUSH : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }

    private boolean todasAsCartasSaoDoMesmoNaipe(List<Carta> cartas) {
        Carta primeiraCarta = cartas.get(0);
        return cartas.stream().allMatch(carta -> primeiraCarta.getNaipe().equals(carta.getNaipe()));
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        if(possuemAMesmaMao(jogador1, jogador2)){
            return new CartaAlta().desempata(jogador1, jogador2);
        }
        int totalDePontosDaCartaDoJogador1 = jogador1.obterCartas().stream().mapToInt(Carta::calcularOValorDaCarta).sum();
        int totalDePontosDaCartaDoJogador2 = jogador2.obterCartas().stream().mapToInt(Carta::calcularOValorDaCarta).sum();
        return totalDePontosDaCartaDoJogador1 > totalDePontosDaCartaDoJogador2 ? jogador1 : jogador2;
    }

    private boolean possuemAMesmaMao(Jogador jogador1, Jogador jogador2) {
        return jogador1.obterCartas().stream().allMatch(cartaDoJogador1 -> jogador2.obterCartas().stream().map(Carta::getValor).collect(Collectors.toList()).contains(cartaDoJogador1.getValor()));
    }
}
