package poker.carta;

public enum Naipe {
	OURO("D"),
	COPA("H"),
	ESPADAS("S"),
	PAUS("C");

	private String descricao;

	Naipe(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}