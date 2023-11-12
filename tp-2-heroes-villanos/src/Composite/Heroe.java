package Composite;

public class Heroe extends Personaje {

	public Heroe(String nombreReal, String nombrePersonaje, int fuerza, int resistencia, int velocidad, int destreza) {
		super(nombreReal, nombrePersonaje, fuerza, resistencia, velocidad, destreza);
	}

	@Override
	public String toString() {
		return "Heroe [Nombre de héroe=" + nombrePersonaje + "]";
	}

	@Override
	public boolean esHeroe() {
		return true;
	}

	@Override
	public boolean esVillano() {
		return false;
	}

}