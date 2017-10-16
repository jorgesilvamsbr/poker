package poker.jogada;

import poker.Jogador;
import poker.carta.Carta;

import java.util.List;

public class Trinca implements Jogada {
    private int quantidadeDeCartasIguais;

    @Override
    public TipoDaJogada validar(Jogador jogador) {
        List<Carta> cartas = jogador.obterCartas();
        for (int i = 0; i < cartas.size() && quantidadeDeCartasIguais < 3; i++) {
            Carta cartaASerComparada = cartas.get(i);
            this.quantidadeDeCartasIguais = 0;
            cartas.forEach(carta -> {
                if (cartaASerComparada.getValor().equals(carta.getValor())) {
                    quantidadeDeCartasIguais++;
                }
            });
        }
        return quantidadeDeCartasIguais == 3 ? TipoDaJogada.TRINCA : TipoDaJogada.NENHUMA_JOGADA_ENCONTRADA;
    }

    @Override
    public Jogador desempata(Jogador jogador1, Jogador jogador2) {
        return null;
    }
}
