package Composite;

import org.junit.Assert;
import org.junit.Test;

public class VillanoTests {

	@Test
	public void testCrearVillano() {
		String resultadoEsperado = "Villano [Nombre de Villano=Harley Quinn]";
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Assert.assertEquals(p.toString(), resultadoEsperado);
	}
	
	@Test
	public void testEsVillano() {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Assert.assertEquals(p.esVillano(), true);
	}

	@Test
	public void testEsHeroe() {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Assert.assertEquals(p.esHeroe(), false);
	}
}
