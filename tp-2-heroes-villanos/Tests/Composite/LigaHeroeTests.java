package Composite;

import org.junit.Assert;
import org.junit.Test;

import Exceptions.AddToLeagueException;

public class LigaHeroeTests {

	@Test
	public void testEsLigaHeroe() {
		Liga liga = new LigaHeroe("Liga de la justicia");

		Assert.assertEquals(liga.esLigaHeroe(), true);
	}

	@Test
	public void testEsLigaVillano() {
		Liga liga = new LigaHeroe("Liga de la justicia");

		Assert.assertEquals(liga.esLigaVillano(), false);
	}

	@Test
	public void testAgregarHeroes() throws AddToLeagueException {
		String resultadoEsperado = "Liga de la justicia, Batman, Superman";

		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p1);
		ligaDeLaJusticia.agregarCompetidor(p2);

		Assert.assertEquals(ligaDeLaJusticia.toString(), resultadoEsperado);
	}

	@Test
	public void testAgregarLigasAnidadas() throws AddToLeagueException {
		String resultadoEsperado = "Liga de la justicia Total, Liga de la justicia 1, Liga de la justicia 2";

		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);
		Personaje p3 = new Heroe("Arthur Curry", "Aquaman", 100, 200, 200, 100);
		Personaje p4 = new Heroe("Hal Jordan", "Linterna Verde", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia_1 = new LigaHeroe("Liga de la justicia 1");
		ligaDeLaJusticia_1.agregarCompetidor(p1);
		ligaDeLaJusticia_1.agregarCompetidor(p2);

		LigaHeroe ligaDeLaJusticia_2 = new LigaHeroe("Liga de la justicia 2");
		ligaDeLaJusticia_2.agregarCompetidor(p3);
		ligaDeLaJusticia_2.agregarCompetidor(p4);

		LigaHeroe ligaDeLaJusticiaTotal = new LigaHeroe("Liga de la justicia Total");
		ligaDeLaJusticiaTotal.agregarCompetidor(ligaDeLaJusticia_1);
		ligaDeLaJusticiaTotal.agregarCompetidor(ligaDeLaJusticia_2);

		Assert.assertEquals(ligaDeLaJusticiaTotal.toString(), resultadoEsperado);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarHeroeADosLigas() throws AddToLeagueException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);

		LigaHeroe ligaDeLaJusticia_1 = new LigaHeroe("Liga de la justicia 1");
		LigaHeroe ligaDeLaJusticia_2 = new LigaHeroe("Liga de la justicia 2");

		ligaDeLaJusticia_1.agregarCompetidor(p);
		ligaDeLaJusticia_2.agregarCompetidor(p);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarLigaADosLigas() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);

		LigaHeroe ligaDeLaJusticia_1 = new LigaHeroe("Liga de la justicia 1");
		LigaHeroe ligaDeLaJusticia_2 = new LigaHeroe("Liga de la justicia 2");
		LigaHeroe ligaDeLaJusticia_3 = new LigaHeroe("Liga de la justicia 3");

		ligaDeLaJusticia_1.agregarCompetidor(p1);
		ligaDeLaJusticia_2.agregarCompetidor(ligaDeLaJusticia_1);
		ligaDeLaJusticia_3.agregarCompetidor(ligaDeLaJusticia_1);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarHeroeMismaLiga() throws AddToLeagueException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);

		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia 1");

		ligaDeLaJusticia.agregarCompetidor(p);
		ligaDeLaJusticia.agregarCompetidor(p);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarLigaMismaLigaAnidada() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);

		LigaHeroe ligaDeLaJusticia_1 = new LigaHeroe("Liga de la justicia 1");
		LigaHeroe ligaDeLaJusticia_2 = new LigaHeroe("Liga de la justicia 2");

		ligaDeLaJusticia_1.agregarCompetidor(p1);
		ligaDeLaJusticia_2.agregarCompetidor(ligaDeLaJusticia_1);
		ligaDeLaJusticia_2.agregarCompetidor(ligaDeLaJusticia_1);
	}
	
	@Test(expected = AddToLeagueException.class)
	public void testAgregarLigaSiMisma() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);

		LigaHeroe ligaDeLaJusticia_1 = new LigaHeroe("Liga de la justicia 1");

		ligaDeLaJusticia_1.agregarCompetidor(p1);
		ligaDeLaJusticia_1.agregarCompetidor(ligaDeLaJusticia_1);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarVillanoLigaHeroe() throws AddToLeagueException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);

		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarLigaVillanoLigaHeroe() throws AddToLeagueException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 100, 100, 100, 50);

		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);

		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(ligaVillanos);
	}
}
