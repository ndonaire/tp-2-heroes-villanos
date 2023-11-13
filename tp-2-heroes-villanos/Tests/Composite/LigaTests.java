package Composite;

import org.junit.Assert;
import org.junit.Test;

import Exceptions.AddToLeagueException;
import Exceptions.DeleteCompetitorException;
import Exceptions.FeatureLevelException;
import State.Caracteristica;

public class LigaTests {

	@Test
	public void testEsHeroe() {
		Liga liga = new LigaHeroe("Liga de la justicia");

		Assert.assertEquals(liga.esHeroe(), false);
	}

	@Test
	public void testEsVillano() {
		Liga liga = new LigaHeroe("Liga de la justicia");

		Assert.assertEquals(liga.esVillano(), false);
	}

	@Test
	public void testEliminarCompetidor() throws AddToLeagueException, DeleteCompetitorException, FeatureLevelException {
		String resultadoEsperado = "Liga de la justicia, Superman";
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p1);
		ligaDeLaJusticia.agregarCompetidor(p2);

		ligaDeLaJusticia.eliminarCompetidor(p1);

		Assert.assertEquals(ligaDeLaJusticia.toString(), resultadoEsperado);
	}

	@Test
	public void testEliminarLigaAnidada() throws AddToLeagueException, DeleteCompetitorException, FeatureLevelException {
		String resultadoEsperado = "Liga de la justicia 2";
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia1 = new LigaHeroe("Liga de la justicia 1");
		ligaDeLaJusticia1.agregarCompetidor(p1);
		ligaDeLaJusticia1.agregarCompetidor(p2);

		LigaHeroe ligaDeLaJusticia2 = new LigaHeroe("Liga de la justicia 2");

		ligaDeLaJusticia2.agregarCompetidor(ligaDeLaJusticia1);
		ligaDeLaJusticia2.eliminarCompetidor(ligaDeLaJusticia1);

		Assert.assertEquals(ligaDeLaJusticia2.toString(), resultadoEsperado);
	}

	@Test(expected = DeleteCompetitorException.class)
	public void testEliminarCompetidorSinLiga() throws AddToLeagueException, DeleteCompetitorException, FeatureLevelException {
		
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p2);

		ligaDeLaJusticia.eliminarCompetidor(p1);

	}

	@Test(expected = DeleteCompetitorException.class)
	public void testEliminarLigaSinLigaAnidada() throws AddToLeagueException, DeleteCompetitorException, FeatureLevelException {
		
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia1 = new LigaHeroe("Liga de la justicia 1");
		ligaDeLaJusticia1.agregarCompetidor(p1);

		LigaHeroe ligaDeLaJusticia2 = new LigaHeroe("Liga de la justicia 2");
		ligaDeLaJusticia2.agregarCompetidor(p2);

		ligaDeLaJusticia2.eliminarCompetidor(ligaDeLaJusticia1);
	
	}
	
	@Test(expected = DeleteCompetitorException.class)
	public void testEliminarCompetidorFueraDeLiga() throws AddToLeagueException, DeleteCompetitorException, FeatureLevelException {
		
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia1 = new LigaHeroe("Liga de la justicia 1");
		ligaDeLaJusticia1.agregarCompetidor(p1);
		
		LigaHeroe ligaDeLaJusticia2 = new LigaHeroe("Liga de la justicia 2");
		ligaDeLaJusticia2.agregarCompetidor(p2);

		ligaDeLaJusticia1.eliminarCompetidor(p2);

	}

	@Test(expected = DeleteCompetitorException.class)
	public void testEliminarLigaFueraDeLigaAnidada() throws AddToLeagueException, DeleteCompetitorException, FeatureLevelException {
		
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia1 = new LigaHeroe("Liga de la justicia 1");
		ligaDeLaJusticia1.agregarCompetidor(p1);

		LigaHeroe ligaDeLaJusticia2 = new LigaHeroe("Liga de la justicia 2");
		ligaDeLaJusticia2.agregarCompetidor(p2);
		
		LigaHeroe ligaDeLaJusticia3 = new LigaHeroe("Liga de la justicia 3");
		ligaDeLaJusticia3.agregarCompetidor(ligaDeLaJusticia1);
		
		LigaHeroe ligaDeLaJusticia4 = new LigaHeroe("Liga de la justicia 4");
		ligaDeLaJusticia4.agregarCompetidor(ligaDeLaJusticia2);
		
		ligaDeLaJusticia3.eliminarCompetidor(ligaDeLaJusticia2);
	
	}
	
	@Test
	public void testLigaVsLigaEsGanador() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 50, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 50, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 100);
		Personaje p4 = new Heroe("Clark Kent", "Superman", 100, 100, 100, 100);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p3);
		ligaDeLaJusticia.agregarCompetidor(p4);

		Assert.assertEquals(ligaDeLaJusticia.esGanador(ligaVillanos, new Caracteristica(2)), true);
		
	}
	
	@Test
	public void testLigaVsCompetidorEsGanador() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 500, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 500, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 100);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);

		Assert.assertEquals(ligaVillanos.esGanador(p3, new Caracteristica(2)), true);
		
	}
	
	@Test
	public void testLigaVsLigaNoEsGanador() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 50, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 50, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 100, 0, 100, 100);
		Personaje p4 = new Heroe("Clark Kent", "Superman", 100, 0, 100, 100);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p3);
		ligaDeLaJusticia.agregarCompetidor(p4);

		Assert.assertEquals(ligaDeLaJusticia.esGanador(ligaVillanos, new Caracteristica(2)), false);
		
	}
	
	@Test
	public void testLigaVsCompetidorNoEsGanador() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 500, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 500, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 100);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);

		Assert.assertEquals(ligaVillanos.esGanador(p3, new Caracteristica(1)), false);
		
	}
	
	@Test
	public void testLigaVsLigaEmpateGana() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 50, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 50, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 100, 50, 100, 100);
		Personaje p4 = new Heroe("Clark Kent", "Superman", 100, 50, 100, 100);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p3);
		ligaDeLaJusticia.agregarCompetidor(p4);

		Assert.assertEquals(ligaDeLaJusticia.esGanador(ligaVillanos, new Caracteristica(2)), true);
		
	}
	
	@Test
	public void testLigaVsCompetidorEmpateGana() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 500, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 500, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 100);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);

		Assert.assertEquals(ligaVillanos.esGanador(p3, new Caracteristica(1)), false);
		
	}
	
	@Test
	public void testLigaVsLigaEmpatePierde() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 50, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 50, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 100, 50, 0, 100);
		Personaje p4 = new Heroe("Clark Kent", "Superman", 100, 50, 0, 100);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p3);
		ligaDeLaJusticia.agregarCompetidor(p4);

		Assert.assertEquals(ligaDeLaJusticia.esGanador(ligaVillanos, new Caracteristica(2)), false);
		
	}
	
	@Test
	public void testLigaVsCompetidorEmpatePierde() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 500, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 500, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 50, 1000, 100, 100);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);

		Assert.assertEquals(ligaVillanos.esGanador(p3, new Caracteristica(1)), false);
		
	}
	
	@Test
	public void testLigaVsLigaEmpateFinal() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 50, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 50, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 50, 50, 50, 50);
		Personaje p4 = new Heroe("Clark Kent", "Superman", 50, 50, 50, 50);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		LigaHeroe ligaDeLaJusticia = new LigaHeroe("Liga de la justicia");
		ligaDeLaJusticia.agregarCompetidor(p3);
		ligaDeLaJusticia.agregarCompetidor(p4);

		Assert.assertEquals(ligaDeLaJusticia.esGanador(ligaVillanos, new Caracteristica(2)), false);
		
	}
	
	@Test
	public void testLigaVsCompetidorEmpateFinal() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 50, 500, 50, 50);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 50, 500, 50, 50);
		
		Personaje p3 = new Heroe("Bruno Diaz", "Batman", 50, 500, 50, 50);
						
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);

		Assert.assertEquals(ligaVillanos.esGanador(p3, new Caracteristica(1)), false);
		
	}

	@Test
	public void testGetFuerza() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 500, 350, 400, 100);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 150, 300, 500, 150);
		
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		Assert.assertEquals(ligaVillanos.getFuerza(),325);
	}
	
	@Test
	public void testGetResistencia() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 500, 350, 400, 100);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 150, 300, 500, 150);
		
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		Assert.assertEquals(ligaVillanos.getResistencia(),325);
	}
	
	@Test
	public void testGetDestreza() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 500, 350, 400, 100);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 150, 300, 500, 150);
		
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		Assert.assertEquals(ligaVillanos.getDestreza(),450);
	}
	
	@Test
	public void testGetVelocidad() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 500, 350, 400, 100);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 150, 300, 500, 150);
		
		LigaVillano ligaVillanos = new LigaVillano("Villanas");
		ligaVillanos.agregarCompetidor(p1);
		ligaVillanos.agregarCompetidor(p2);
		
		Assert.assertEquals(ligaVillanos.getVelocidad(),125);
	}
	
	@Test
	public void testGetEstaEnAlgunaLigaTrue() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 500, 350, 400, 100);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 150, 300, 500, 150);
		
		LigaVillano ligaVillanos1 = new LigaVillano("Villanas 1");
		ligaVillanos1.agregarCompetidor(p1);
		ligaVillanos1.agregarCompetidor(p2);
		
		LigaVillano ligaVillanos2 = new LigaVillano("Villanas 2");
		ligaVillanos2.agregarCompetidor(ligaVillanos1);
		
		Assert.assertEquals(ligaVillanos1.getEstaEnAlgunaLiga(),true);
	}
	
	@Test
	public void testGetEstaEnAlgunaLigaFalse() throws AddToLeagueException, FeatureLevelException {
		Personaje p1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 500, 350, 400, 100);
		Personaje p2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 150, 300, 500, 150);
		
		LigaVillano ligaVillanos1 = new LigaVillano("Villanas 1");
		ligaVillanos1.agregarCompetidor(p1);
		ligaVillanos1.agregarCompetidor(p2);
		
		Assert.assertEquals(ligaVillanos1.getEstaEnAlgunaLiga(),false);
	}
}
