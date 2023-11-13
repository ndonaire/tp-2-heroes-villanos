package Composite;

import org.junit.Assert;
import org.junit.Test;

import Exceptions.FeatureLevelException;

public class VillanoTests {

	@Test
	public void testCrearVillano() throws FeatureLevelException {
		String resultadoEsperado = "Villano, Harleen Frances Quinzel  , Harley Quinn             ,   50,  100,  100,  100";
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Assert.assertEquals(p.toString(), resultadoEsperado);
	}
	
	@Test (expected = FeatureLevelException.class)
	public void testCrearVillanoValoresNegativos() throws FeatureLevelException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", -100, 100, 100, 50);
	}
	
	@Test
	public void testEsVillano() throws FeatureLevelException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Assert.assertEquals(p.esVillano(), true);
	}

	@Test
	public void testEsHeroe() throws FeatureLevelException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Assert.assertEquals(p.esHeroe(), false);
	}
}
