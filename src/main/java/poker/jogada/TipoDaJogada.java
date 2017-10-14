package poker.jogada;

import java.util.Arrays;
import java.util.List;

public enum TipoDaJogada {
    NENHUMA_JOGADA_ENCONTRADA("Não foi encontrado nenhuma jogada", -1),
    CARTA_ALTA("A carta de maior valor", 0),
    UM_PAR("Duas cartas do mesmo valor", 1),
    DOIS_PARES("Dois pares diferentes", 2),
    TRINCA("Três cartas do mesmo valor e duas de valores diferentes", 3),
    STRAIGHT("Todas as carta com valores consecutivos", 4),
    FLUSH("Todas as cartas do mesmo naipe",5),
    FULL_HOUSE("Um trinca e um par", 6),
    QUADRA("Quatro cartas do mesmo valor", 7),
    STRAIGHT_FLUSH("Todas as cartas são consecutivas e do mesmo naipe", 8),
    ROYAL_FLUSH("A seqüência 10, Valete, Dama, Rei, Ás, do mesmo naipe.", 9);

    private String descricao;
    private int pesoDaJogada;

    TipoDaJogada(String descricao, int pesoDaJogada) {
        this.descricao = descricao;
        this.pesoDaJogada = pesoDaJogada;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPesoDaJogada() {
        return pesoDaJogada;
    }

    public static List<TipoDaJogada> obterTodas() {
        return Arrays.asList(CARTA_ALTA, UM_PAR, DOIS_PARES, TRINCA, STRAIGHT, FLUSH, FULL_HOUSE, QUADRA, STRAIGHT_FLUSH, ROYAL_FLUSH);
    }

    public boolean ehMaiorQue(TipoDaJogada tipoDaJogada) {
        return this.getPesoDaJogada() > tipoDaJogada.getPesoDaJogada();
    }

    public boolean isSemJogada() {
        return NENHUMA_JOGADA_ENCONTRADA.equals(this);
    }

    public boolean isTrinca() {
        return TRINCA.equals(this);
    }

    public boolean isUmPar() {
        return UM_PAR.equals(this);
    }
}
