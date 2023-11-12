import Composite.Personaje;
import Composite.Heroe;
import Composite.Villano;
import Exceptions.AddToLeagueException;
import State.Caracteristica;
import Composite.LigaHeroe;
import Composite.LigaVillano;

public class Main {

	public static void main(String[] args) throws AddToLeagueException {
		Personaje p1 = new Heroe("Bruno Diaz", "Batman", 100, 100, 100, 50);
		Personaje p2 = new Heroe("Clark Kent", "Superman", 100, 200, 200, 100);
		Personaje p3 = new Villano("Jack Oswald White", "Joker", 100, 200, 200, 100);
		Personaje p4 = new Villano("Alexander Joseph", "Lex lutor", 100, 200, 200, 100);
		Personaje p5 = new Villano("Vril Dox", "Brainiac", 100, 200, 200, 100);
		Personaje p6 = new Heroe("Arthur Curry", "Aquaman", 100, 200, 200, 100);
		Personaje p7 = new Heroe("Hal Jordan", "Linterna Verde", 100, 200, 200, 100);
		Personaje p8 = new Heroe("Barry Allen", "Flash", 100, 200, 200, 100);
		
		LigaHeroe ligaDeLaJusticia_1 = new LigaHeroe("ligaDeLaJusticia_1");
		ligaDeLaJusticia_1.agregarCompetidor(p1);
		ligaDeLaJusticia_1.agregarCompetidor(p2);
		System.out.println(ligaDeLaJusticia_1.toString());

		LigaHeroe ligaDeLaJusticia_2 = new LigaHeroe("ligaDeLaJusticia_2");
		ligaDeLaJusticia_2.agregarCompetidor(p6);
		ligaDeLaJusticia_2.agregarCompetidor(p7);
		System.out.println(ligaDeLaJusticia_2.toString());

		LigaHeroe ligaDeLaJusticia_final = new LigaHeroe("ligaDeLaJusticia_final");
		ligaDeLaJusticia_final.agregarCompetidor(ligaDeLaJusticia_1);
		ligaDeLaJusticia_final.agregarCompetidor(ligaDeLaJusticia_2);
		ligaDeLaJusticia_final.agregarCompetidor(p8);
		System.out.println(ligaDeLaJusticia_final.toString());

		LigaVillano ligaDeVillanos = new LigaVillano("ligaDeVillanos");
		ligaDeVillanos.agregarCompetidor(p3);
		ligaDeVillanos.agregarCompetidor(p4);
		ligaDeVillanos.agregarCompetidor(p5);
		System.out.println(ligaDeVillanos.toString());

		//System.out.println(p1.esGanador(p2, new Caracteristica(2)));
		//System.out.println(ligaDeLaJusticia_final.esGanador(p5, new Caracteristica(2)));
		System.out.println(ligaDeVillanos.esGanador(ligaDeLaJusticia_final, new Caracteristica(1)));
		
		Personaje v1 = new Villano("Harleen Frances Quinzel", "Harley Quinn", 100, 100, 100, 50);
		Personaje v2 = new Villano("Pamela Lillian Isley", "Hiedra Venenosa", 100, 100, 100, 50);

		LigaVillano ligaVillanas = new LigaVillano("Villanas");
		ligaVillanas.agregarCompetidor(v1);
		ligaVillanas.agregarCompetidor(v2);
		System.out.println(ligaVillanas.toString());
		

	}

}
