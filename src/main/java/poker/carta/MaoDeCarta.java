package poker.carta;

import java.util.Collections;
import java.util.List;

public class MaoDeCarta {
    private List<Carta> cartas;

    public MaoDeCarta(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<Carta> getCartas() {
        return Collections.unmodifiableList(cartas);
    }
}
