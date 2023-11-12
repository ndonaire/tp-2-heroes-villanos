package Composite;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Exceptions.AddToLeagueException;
import State.Caracteristica;

public class PersonajeTests {

	@Test
	public void testEsLigaHeroe() {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		
		Assert.assertEquals(p.esLigaHeroe(), false);
	}

	@Test
	public void testEsLigaVillano() {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		
		Assert.assertEquals(p.esLigaVillano(), false);
	}
	
	@Test
	public void testCompetidorVsCompetidorEsGanador() {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);

		Assert.assertEquals(p1.esGanador(p2,new Caracteristica(2)), true);
	}
	
	@Test
	public void testCompetidorVsLigaEsGanador() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		
		LigaVillano ligaVillanos = new LigaVillano ("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos,new Caracteristica(1)), true);
	}
	
	@Test
	public void testCompetidorVsCompetidorNoEsGanador() {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);

		Assert.assertEquals(p1.esGanador(p2,new Caracteristica(4)), false);
	}
	
	@Test
	public void testCompetidorVsLigaNoEsGanador() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 30, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		
		LigaVillano ligaVillanos = new LigaVillano ("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos,new Caracteristica(1)), false);
	}
	
	@Test
	public void testCompetidorVsCompetidorEmpateGana() {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);

		Assert.assertEquals(p1.esGanador(p2,new Caracteristica(1)), true);
	}
	
	@Test
	public void testCompetidorVsLigaEmpateGana() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 1000, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 300, 200, 200, 100);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 300, 100, 100, 50);
		
		LigaVillano ligaVillanos = new LigaVillano ("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos,new Caracteristica(1)), true);
	}
	
	@Test
	public void testCompetidorVsCompetidorEmpatePierde() {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);

		Assert.assertEquals(p1.esGanador(p2,new Caracteristica(1)), false);
	}
	
	@Test
	public void testCompetidorVsLigaEmpatePierde() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 300, 200, 200, 100);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 300, 100, 100, 50);
		
		LigaVillano ligaVillanos = new LigaVillano ("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos,new Caracteristica(1)), false);
	}
	
	@Test
	public void testCompetidorVsCompetidorEmpateFinal() {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 100, 100, 120, 50);

		Assert.assertEquals(p1.esGanador(p2,new Caracteristica(1)), false);
	}
	
	@Test
	public void testCompetidorVsLigaEmpateFinal() throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Personaje p2 = new Villano("Jack Oswald White", "Joker", 300, 100, 120, 50);
		Personaje p3 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 300, 100, 120, 50);
		
		LigaVillano ligaVillanos = new LigaVillano ("Liga Villanos");
		ligaVillanos.agregarCompetidor(p2);
		ligaVillanos.agregarCompetidor(p3);

		Assert.assertEquals(p1.esGanador(ligaVillanos,new Caracteristica(1)), false);
	}
	
	@Test
	public void testGetFuerza() {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Assert.assertEquals(p.getFuerza(),300);		
	}
	
	@Test
	public void testGetResistencia() {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Assert.assertEquals(p.getResistencia(),100);		
	}
	
	@Test
	public void testGetDestreza() {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Assert.assertEquals(p.getDestreza(),120);		
	}
	
	@Test
	public void testGetVelocidad() {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		Assert.assertEquals(p.getVelocidad(),50);		
	}
	
	@Test
	public void testGetEstaEnAlgunaLigaTrue() throws AddToLeagueException {
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		LigaHeroe ligaDeLaJusticia = new LigaHeroe ("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p);
		Assert.assertEquals(p.getEstaEnAlgunaLiga(),true);		
	}
	
	@Test
	public void testGetEstaEnAlgunaLigaFalse(){
		Personaje p = new Heroe("Bruno Diaz", "Batman", 300, 100, 120, 50);
		
		Assert.assertEquals(p.getEstaEnAlgunaLiga(),false);		
	}

}
