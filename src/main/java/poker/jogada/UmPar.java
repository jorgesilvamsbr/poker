package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;

public class UmPar implements Jogada {

    private int quantidadeDeCartasIguais;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        for (int i = 0; i < cartas.size() && quantidadeDeCartasIguais < 2; i++) {
            Carta cartaASerComparada = cartas.get(i);
            this.quantidadeDeCartasIguais = 0;
            cartas.forEach(carta -> {
                if (cartaASerComparada.getValor().equals(carta.getValor())) {
                    quantidadeDeCartasIguais++;
                }
            });
        }
        return quantidadeDeCartasIguais == 2 ? TipoDaJogada.UM_PAR : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }
}
