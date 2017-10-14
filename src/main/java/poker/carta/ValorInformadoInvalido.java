package poker.carta;

public class ValorInformadoInvalido extends Exception {
    public ValorInformadoInvalido() {
        super("O valor informado esta vazio");
    }
}
