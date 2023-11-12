package Composite;

public class Heroe extends Personaje {

	public Heroe(String nombreReal, String nombrePersonaje, int fuerza, int resistencia, int destreza, int velocidad) {
		super(nombreReal, nombrePersonaje, fuerza, resistencia, destreza, velocidad);
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

	@Override
	public String getNombreLiga() {
		return null;
	}

}