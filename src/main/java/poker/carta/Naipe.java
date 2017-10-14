package poker.carta;

public enum Naipe {
	OURO("D", 1),
	COPA("H", 2),
	ESPADAS("S", 3),
	PAUS("C", 4);

	private String descricao;
	private int valor;

	private Naipe(String descricao, int valor){
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getValor() {
		return valor;
	}
}