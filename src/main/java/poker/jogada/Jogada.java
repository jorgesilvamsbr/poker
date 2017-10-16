package poker.jogada;

import poker.Jogador;

public interface Jogada {
    TipoDaJogada validar(Jogador jogador);
    Jogador desempata(Jogador jogador1, Jogador jogador2);
}
