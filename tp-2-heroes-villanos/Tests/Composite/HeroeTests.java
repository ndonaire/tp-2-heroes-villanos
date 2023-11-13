package Composite;

import org.junit.Assert;
import org.junit.Test;

import Exceptions.FeatureLevelException;

public class HeroeTests {

	@Test
	public void testCrearHeroe() throws FeatureLevelException {
		String resultadoEsperado = "Heroe  , Bruno Diaz               , Batman                   ,   50,  100,  100,  100";
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Assert.assertEquals(p.toString(), resultadoEsperado);
	}
	
	@Test (expected = FeatureLevelException.class)
	public void testCrearHeroeValoresNegativos() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", -100, 100, 100, 50);
	}

	@Test
	public void testEsHeroe() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Assert.assertEquals(p.esHeroe(), true);
	}

	@Test
	public void testEsVillano() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Assert.assertEquals(p.esVillano(), false);
	}

}
