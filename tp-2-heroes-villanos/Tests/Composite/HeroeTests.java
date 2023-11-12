package Composite;

import org.junit.Assert;
import org.junit.Test;

public class HeroeTests {

	@Test
	public void testCrearHeroe() {
		String resultadoEsperado = "Heroe [Nombre de héroe=Batman]";
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Assert.assertEquals(p.toString(), resultadoEsperado);
	}

	@Test
	public void testEsHeroe() {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Assert.assertEquals(p.esHeroe(), true);
	}

	@Test
	public void testEsVillano() {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Assert.assertEquals(p.esVillano(), false);
	}

}
