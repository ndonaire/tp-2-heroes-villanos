package Composite;

import static org.junit.Assert.*;

import org.junit.Test;

class LigaHeroeTests {

	@Test
	void testAgregarHeroes() {
		String resultadoEsperado = "Liga: Liga de la justicia 1[[Heroe [Nombre de héroe=Batman], Heroe [Nombre de héroe=Superman]]]";

		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);

		LigaHeroe ligaDeLaJusticia_1 = new LigaHeroe("Liga de la justicia 1");
		ligaDeLaJusticia_1.agregarCompetidor(p1);
		ligaDeLaJusticia_1.agregarCompetidor(p2);

		assertEquals(ligaDeLaJusticia_1.toString(), resultadoEsperado);
	}

	@Test(expected= RuntimeException.class)
	void testAgregarHeroesADosLigas() {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		
		LigaHeroe ligaDeLaJusticia_1 = new LigaHeroe("Liga de la justicia 1");
		LigaHeroe ligaDeLaJusticia_2 = new LigaHeroe("Liga de la justicia 2");
		ligaDeLaJusticia_1.agregarCompetidor(p1);
		ligaDeLaJusticia_2.agregarCompetidor(p1);		
	}

}
