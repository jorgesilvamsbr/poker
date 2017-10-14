package poker.carta;

public class Carta {
	private static String VALETE = "J";
	private static String DAMA = "Q";
	private static String REIS = "K";
	private static String AS = "A";
	private Naipe naipe;
	private String valor;

	public Carta(String valor, Naipe naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	public static Carta criar(String valor, Naipe naipe) throws NaipeInformadoEhNulo, ValorInformadoInvalido {
		validar(naipe, valor);
		return new Carta(valor, naipe);
	}

	private static void validar(Naipe naipe, String valor) throws NaipeInformadoEhNulo, ValorInformadoInvalido {
		if(naipe == null){
			throw new NaipeInformadoEhNulo();
		}
		if(valor.isEmpty()){
			throw new ValorInformadoInvalido();
		}
	}

	public Naipe getNaipe() {
		return naipe;
	}
	
	public String getValor() {
		return valor;
	}

	public Integer calcularOValorDaCarta() {
		return this.naipe.getValor() + converterOValorCasoSejaUmaCartaEspecial();
	}

	private int converterOValorCasoSejaUmaCartaEspecial() {
		if(this.valor == VALETE){
			return 11;
		}else if(this.valor == DAMA){
			return 12;
		}else if(this.valor == REIS){
			return 13;
		}else if(this.valor == AS) {
			return 14;
		}
		return Integer.valueOf(this.valor);
	}

	public String obterValorConsecutivo(){
		if(this.valor == VALETE){
			return DAMA;
		}else if(this.valor == DAMA){
			return REIS;
		}else if(this.valor == REIS){
			return AS;
		}else if(this.valor == AS) {
			return "2";
		}
		return String.valueOf(Integer.valueOf(this.valor) + 1);
	}
}
