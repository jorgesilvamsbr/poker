package poker;

import org.junit.Test;
import poker.carta.Carta;
import poker.carta.MaoDeCarta;
import poker.carta.Naipe;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArbitroTest {

	private Arbitro arbitro = new Arbitro();

	@Test
	public void deve_dar_o_resultado_do_jogo_para_o_jogador_com_o_par_mais_alto() throws Exception {
		List<Carta> cartas1 = Arrays.asList(Carta.criar("5", Naipe.COPA), Carta.criar("5", Naipe.PAUS), Carta.criar("6", Naipe.ESPADAS), Carta.criar("7", Naipe.ESPADAS), Carta.criar("K", Naipe.OURO));
		List<Carta> cartas2 = Arrays.asList(Carta.criar("2", Naipe.PAUS), Carta.criar("3", Naipe.ESPADAS), Carta.criar("8", Naipe.ESPADAS), Carta.criar("8", Naipe.OURO), Carta.criar("10", Naipe.OURO));
		MaoDeCarta maoDeCartas1 = new MaoDeCarta(cartas1);
		MaoDeCarta maoDeCartas2 = new MaoDeCarta(cartas2);
		Jogador jogador1 = new Jogador(maoDeCartas1);
		Jogador jogador2 = new Jogador(maoDeCartas2);
		
		Jogador vencedor = arbitro.obterVencedor(jogador1, jogador2);
		
		assertEquals(jogador2, vencedor);
	}

	@Test
	public void deve_dar_o_resultado_do_jogo_para_o_jogador_com_a_carta_mais_alta() throws Exception {
		List<Carta> cartas1 = Arrays.asList(Carta.criar("5", Naipe.OURO), Carta.criar("8", Naipe.PAUS), Carta.criar("9", Naipe.ESPADAS), Carta.criar("J", Naipe.ESPADAS), Carta.criar("A", Naipe.PAUS));
		List<Carta> cartas2 = Arrays.asList(Carta.criar("2", Naipe.PAUS), Carta.criar("5", Naipe.PAUS), Carta.criar("7", Naipe.OURO), Carta.criar("8", Naipe.ESPADAS), Carta.criar("Q", Naipe.COPA));
		MaoDeCarta maoDeCartas1 = new MaoDeCarta(cartas1);
		MaoDeCarta maoDeCartas2 = new MaoDeCarta(cartas2);
		Jogador jogador1 = new Jogador(maoDeCartas1);
		Jogador jogador2 = new Jogador(maoDeCartas2);

		Jogador vencedor = arbitro.obterVencedor(jogador1, jogador2);

		assertEquals(jogador1, vencedor);
	}


}
