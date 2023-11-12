package Composite;

import org.junit.Assert;
import org.junit.Test;

import Exceptions.AddToLeagueException;

public class LigaVillanoTests {

	@Test
	public void testEsLigaVillano() {
		Liga liga = new LigaVillano("Liga de Villanos");

		Assert.assertEquals(liga.esLigaVillano(), true);
	}

	@Test
	public void testEsLigaHeroe() {
		Liga liga = new LigaVillano("Liga de Villanos");

		Assert.assertEquals(liga.esLigaHeroe(), false);
	}

	@Test
	public void testAgregarVillanos() throws AddToLeagueException {
		String resultadoEsperado = "Villanas, Harley Quinn, Hiedra Venenosa";

		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 100, 100, 100, 50);

		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);

		Assert.assertEquals(ligaVillanos.toString(), resultadoEsperado);
	}

	@Test
	public void testAgregarLigasAnidadas() throws AddToLeagueException {
		String resultadoEsperado = "Liga Villanos Total, Liga Villanas, liga Villanos";

		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 100, 100, 100, 50);
		Personaje p3 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);
		Personaje p4 = new Villano("Alexander Joseph", "Lex Lutor", 100, 200, 200, 100);

		LigaVillano ligaVillanas = new LigaVillano("Liga Villanas");
		ligaVillanas.agregarCompetidor(p1);
		ligaVillanas.agregarCompetidor(p2);

		LigaVillano ligaVillanos = new LigaVillano("liga Villanos");
		ligaVillanos.agregarCompetidor(p3);
		ligaVillanos.agregarCompetidor(p4);

		LigaVillano ligaVillanosTotal = new LigaVillano("Liga Villanos Total");
		ligaVillanosTotal.agregarCompetidor(ligaVillanas);
		ligaVillanosTotal.agregarCompetidor(ligaVillanos);

		Assert.assertEquals(ligaVillanosTotal.toString(), resultadoEsperado);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarVillanoADosLigas() throws AddToLeagueException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);

		LigaVillano ligaVillanas1 = new LigaVillano("Liga Villanas 1");
		LigaVillano ligaVillanas2 = new LigaVillano("Liga Villanas 2");
		ligaVillanas1.agregarCompetidor(p);
		ligaVillanas2.agregarCompetidor(p);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarLigaADosLigas() throws AddToLeagueException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);

		LigaVillano ligaVillanas1 = new LigaVillano("Liga Villanas 1");
		LigaVillano ligaVillanas2 = new LigaVillano("Liga Villanas 2");
		LigaVillano ligaVillanas3 = new LigaVillano("Liga Villanas 3");

		ligaVillanas1.agregarCompetidor(p);
		ligaVillanas2.agregarCompetidor(ligaVillanas1);
		ligaVillanas3.agregarCompetidor(ligaVillanas1);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarVillanoMismaLiga() throws AddToLeagueException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);

		LigaVillano ligaVillanas = new LigaVillano("Liga Villanas 1");

		ligaVillanas.agregarCompetidor(p);
		ligaVillanas.agregarCompetidor(p);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarLigaMismaLigaAnidada() throws AddToLeagueException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);

		LigaVillano ligaVillanas1 = new LigaVillano("Liga Villanas 1");
		LigaVillano ligaVillanas2 = new LigaVillano("Liga Villanas 2");

		ligaVillanas1.agregarCompetidor(p);
		ligaVillanas2.agregarCompetidor(ligaVillanas1);
		ligaVillanas2.agregarCompetidor(ligaVillanas1);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarLigaSiMisma() throws AddToLeagueException {
		Personaje p = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);

		LigaVillano ligaVillanas1 = new LigaVillano("Liga Villanas 1");
		
		ligaVillanas1.agregarCompetidor(p);
		ligaVillanas1.agregarCompetidor(ligaVillanas1);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarHeroeLigaVillano() throws AddToLeagueException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);

		LigaVillano ligaVillanos = new LigaVillano("Liga Villanos");

		ligaVillanos.agregarCompetidor(p);
	}

	@Test(expected = AddToLeagueException.class)
	public void testAgregarLigaHeroeLigaVillano() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p1);
		ligaDeLaJusticia.agregarCompetidor(p2);

		LigaVillano ligaVillanos = new LigaVillano("Villanos");
		ligaVillanos.agregarCompetidor(ligaDeLaJusticia);
	}
}
