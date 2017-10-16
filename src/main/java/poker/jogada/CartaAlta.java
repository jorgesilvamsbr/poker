package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartaAlta implements Jogada {
    @Override
    public TipoDaJogada validar(Jogador jogador) {
        return TipoDaJogada.CARTA_ALTA;
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        int valorDaMaiorCartaDoJogador1 = jogador1.obterCartas().stream().filter(carta -> agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(jogador1).get(carta.getValor()) < 2).mapToInt(carta -> carta.calcularOValorDaCarta()).max().getAsInt();
        int valorDaMaiorCartaDoJogador2 = jogador2.obterCartas().stream().filter(carta -> agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(jogador2).get(carta.getValor()) < 2).mapToInt(carta -> carta.calcularOValorDaCarta()).max().getAsInt();
        return valorDaMaiorCartaDoJogador1 > valorDaMaiorCartaDoJogador2 ? jogador1 : jogador2;
    }

    private Map<String, Long> agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        return cartas.stream().collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));
    }
}
