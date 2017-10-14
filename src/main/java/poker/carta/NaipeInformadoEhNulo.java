package poker.carta;

public class NaipeInformadoEhNulo extends Exception {
    public NaipeInformadoEhNulo() {
        super("O naipe informado é inválido, favor verificar e tentar novamente.");
    }
}
