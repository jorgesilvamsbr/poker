package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DoisPares implements Jogada {

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        Map<String, Long> valoresDasCartasAgrupados = cartas.stream().collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));
        int quantidadeDePares = valoresDasCartasAgrupados.entrySet().stream().mapToInt(valorDaCartaAgrupado -> valorDaCartaAgrupado.getValue() == 2 ? 1 : 0).sum();
        return quantidadeDePares == 2 ? TipoDaJogada.DOIS_PARES : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
