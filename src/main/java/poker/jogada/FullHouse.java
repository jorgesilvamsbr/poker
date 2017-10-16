package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FullHouse implements Jogada {

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        Trinca jogadaTrinca = new Trinca();
        UmPar jogadaUmPar = new UmPar();
        return jogadaTrinca.validar(jogador).isTrinca() && jogadaUmPar.validar(jogador).isUmPar() ? TipoDaJogada.FULL_HOUSE : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        Map<String, Long> valoresDasCartasAgrupadosJogador1 = agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(jogador1);
        Map<String, Long> valoresDasCartasAgrupadosJogador2 = agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(jogador2);
        List<Carta> paresDoJogador1 = resgatarCartasQueGeraramEmpateDo(jogador1, valoresDasCartasAgrupadosJogador1);
        List<Carta> paresDoJogador2 = resgatarCartasQueGeraramEmpateDo(jogador2, valoresDasCartasAgrupadosJogador2);
        if(possuemAMesmaMao(paresDoJogador1, paresDoJogador2)){
            return new CartaAlta().desempata(jogador1, jogador2);
        }
        return paresDoJogador1.stream().mapToInt(Carta::calcularOValorDaCarta).sum() > paresDoJogador2.stream().mapToInt(Carta::calcularOValorDaCarta).sum() ? jogador1 : jogador2;
    }

    private boolean possuemAMesmaMao(List<Carta> paresDoJogador1, List<Carta> paresDoJogador2) {
        return paresDoJogador1.stream().allMatch(cartaDoJogador1 -> paresDoJogador2.stream().map(Carta::getValor).collect(Collectors.toList()).contains(cartaDoJogador1.getValor()));
    }

    private Map<String, Long> agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        return cartas.stream().collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));
    }

    private List<Carta> resgatarCartasQueGeraramEmpateDo(Jogador jogador, Map<String, Long> valoresDasCartasAgrupados) {
        return jogador.obterCartas().stream().filter(carta -> valoresDasCartasAgrupados.get(carta.getValor()) == 3).collect(Collectors.toList());
    }
}