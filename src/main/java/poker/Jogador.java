package poker;

import poker.carta.Carta;
import poker.carta.MaoDeCarta;

import java.util.List;

public class Jogador {
    private MaoDeCarta maoDeCartas;

    public Jogador(MaoDeCarta maoDeCartas) {
        this.maoDeCartas = maoDeCartas;
    }

    public List<Carta> obterCartas() {
        return maoDeCartas.getCartas();
    }
}
