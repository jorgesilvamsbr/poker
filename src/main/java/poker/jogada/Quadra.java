package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quadra implements Jogada{

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        Map<String, Long> valoresDasCartasAgrupado = agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(jogador);
        int quantidadeDePares = valoresDasCartasAgrupado.entrySet().stream().mapToInt(valorDaCartaAgrupado -> valorDaCartaAgrupado.getValue() == 4 ? 1 : 0).sum();
        return quantidadeDePares == 1 ? TipoDaJogada.QUADRA : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        if(possuemAMesmaMao(jogador1, jogador2)){
            return new CartaAlta().desempata(jogador1,jogador2);
        }
        Map<String, Long> cartasAgrupadasJogador1 = agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(jogador1);
        Map<String, Long> cartasAgrupadasJogador2 = agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(jogador2);
        List<Carta> cartasDoJogador1 = resgatarCartasQueGeraramEmpateDo(jogador1, cartasAgrupadasJogador1);
        List<Carta> cartasDoJogador2 = resgatarCartasQueGeraramEmpateDo(jogador2, cartasAgrupadasJogador2);
        return cartasDoJogador1.stream().mapToInt(Carta::calcularOValorDaCarta).sum() > cartasDoJogador2.stream().mapToInt(Carta::calcularOValorDaCarta).sum() ? jogador1 : jogador2;
    }

    private boolean possuemAMesmaMao(Jogador jogador1, Jogador jogador2) {
        return jogador1.obterCartas().stream().allMatch(cartaDoJogador1 -> jogador2.obterCartas().stream().map(Carta::getValor).collect(Collectors.toList()).contains(cartaDoJogador1.getValor()));
    }
    private Map<String, Long> agruparCartasPorValorEAQuantidadeDeVezesQueSeRepeteNaMao(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        return cartas.stream().collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));
    }
    private List<Carta> resgatarCartasQueGeraramEmpateDo(Jogador jogador, Map<String, Long> valoresDasCartasAgrupados) {
        return jogador.obterCartas().stream().filter(carta -> valoresDasCartasAgrupados.get(carta.getValor()) == 2).collect(Collectors.toList());
    }
}
