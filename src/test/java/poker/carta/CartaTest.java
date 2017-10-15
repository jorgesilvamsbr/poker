package poker.carta;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartaTest {

	private static final String TRES = "3";

	@Test
	public void deve_ter_um_naipe() throws Exception {
		Naipe naipeEsperado = Naipe.OURO;
		
		Carta carta = Carta.criar(TRES, naipeEsperado);
		
		assertEquals(naipeEsperado, carta.getNaipe());
	}
	
	@Test
	public void deve_ter_um_valor() throws Exception {
		String valorEsperado = "5";
		
		Carta carta = Carta.criar(valorEsperado, Naipe.ESPADAS);
		
		assertEquals(valorEsperado, carta.getValor());
	}
	
	@Test(expected = NaipeInformadoEhNulo.class)
	public void nao_deve_ser_possivel_informar_um_naipe_nulo() throws Exception {
		Carta.criar(TRES, null);
	}

	@Test(expected = ValorInformadoInvalido.class)
	public void nao_deve_ser_possivel_informar_um_valor_vazio() throws Exception {
		Carta.criar("", Naipe.OURO);
	}
}
