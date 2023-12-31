package Composite;

import org.junit.Assert;
import org.junit.Test;

import Exceptions.AddToLeagueException;
import Exceptions.FeatureLevelException;
import Exceptions.FriendlyFireException;
import State.Caracteristica;

public class PersonajeTests {

	@Test
	public void testEsLigaHeroe() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);

		Assert.assertEquals(p.esLigaHeroe(), false);
	}

	@Test
	public void testEsLigaVillano() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);

		Assert.assertEquals(p.esLigaVillano(), false);
	}

	@Test
	public void testCompetidorVsCompetidorEsGanador() throws FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);

		Assert.assertEquals(p1.esGanador(p2, new Caracteristica(2)), true);
	}

	@Test
	public void testCompetidorVsLigaEsGanador()
			throws AddToLeagueException, FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);

		LigaVillano ligaVillanos = new LigaVillano("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos, new Caracteristica(1)), true);
	}

	@Test
	public void testCompetidorVsCompetidorNoEsGanador() throws FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);

		Assert.assertEquals(p1.esGanador(p2, new Caracteristica(4)), false);
	}

	@Test
	public void testCompetidorVsLigaNoEsGanador()
			throws AddToLeagueException, FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 30, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);

		LigaVillano ligaVillanos = new LigaVillano("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos, new Caracteristica(1)), false);
	}

	@Test
	public void testCompetidorVsCompetidorEmpateGana() throws FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);

		Assert.assertEquals(p1.esGanador(p2, new Caracteristica(1)), true);
	}

	@Test
	public void testCompetidorVsLigaEmpateGana()
			throws AddToLeagueException, FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 300, 200, 200, 100);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 300, 100, 100, 50);

		LigaVillano ligaVillanos = new LigaVillano("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos, new Caracteristica(1)), true);
	}

	@Test
	public void testCompetidorVsCompetidorEmpatePierde() throws FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);

		Assert.assertEquals(p1.esGanador(p2, new Caracteristica(1)), false);
	}

	@Test
	public void testCompetidorVsLigaEmpatePierde()
			throws AddToLeagueException, FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 300, 200, 200, 100);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 300, 100, 100, 50);

		LigaVillano ligaVillanos = new LigaVillano("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos, new Caracteristica(1)), false);
	}

	@Test
	public void testCompetidorVsCompetidorEmpateFinal() throws FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 100, 120, 50);

		Assert.assertEquals(p1.esGanador(p2, new Caracteristica(1)), false);
	}

	@Test
	public void testCompetidorVsLigaEmpateFinal()
			throws AddToLeagueException, FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 300, 100, 120, 50);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 300, 100, 120, 50);

		LigaVillano ligaVillanos = new LigaVillano("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos, new Caracteristica(1)), false);
	}

	@Test
	public void testGetFuerza() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Assert.assertEquals(p.getFuerza(), 300);
	}

	@Test
	public void testGetResistencia() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Assert.assertEquals(p.getResistencia(), 100);
	}

	@Test
	public void testGetDestreza() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Assert.assertEquals(p.getDestreza(), 120);
	}

	@Test
	public void testGetVelocidad() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Assert.assertEquals(p.getVelocidad(), 50);
	}

	@Test
	public void testGetEstaEnAlgunaLigaTrue() throws AddToLeagueException, FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p);
		Assert.assertEquals(p.getEstaEnAlgunaLiga(), true);
	}

	@Test
	public void testGetEstaEnAlgunaLigaFalse() throws FeatureLevelException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);

		Assert.assertEquals(p.getEstaEnAlgunaLiga(), false);
	}

	@Test(expected = FriendlyFireException.class)
	public void testHeroeVsHeroe() throws FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);
		p1.esGanador(p2, new Caracteristica(2));

	}

	@Test(expected = FriendlyFireException.class)
	public void testHeroeVsLigaHeroe() throws FeatureLevelException, FriendlyFireException, AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);
		Personaje p3 = new Heroe("Arthur Curry", "Aquaman", 100, 200, 200, 100);

		Liga ligaHeroe = new LigaHeroe("Liga Heroe 1");
		ligaHeroe.agregarCompetidor(p2);
		ligaHeroe.agregarCompetidor(p3);

		p1.esGanador(ligaHeroe, new Caracteristica(2));

	}

	@Test(expected = FriendlyFireException.class)
	public void testVillanoVsVillano() throws FeatureLevelException, FriendlyFireException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 500, 350, 400, 100);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 150, 300, 500, 150);
		p1.esGanador(p2, new Caracteristica(2));

	}

	@Test(expected = FriendlyFireException.class)
	public void testVillanoVsLigaVillano() throws FeatureLevelException, FriendlyFireException, AddToLeagueException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 500, 350, 400, 100);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 150, 300, 500, 150);
		Personaje p3 = new Villano("Jack Oswald White", "Joker", 150, 300, 500, 150);

		LigaVillano ligaVillanos = new LigaVillano("Villanos");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p3);

		p2.esGanador(ligaVillanos, new Caracteristica(2));

	}

}
