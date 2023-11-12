package Composite;

public class Villano extends Personaje {

	public Villano(String nombreReal, String nombrePersonaje, int fuerza, int resistencia, int destreza,
			int velocidad) {
		super(nombreReal, nombrePersonaje, fuerza, resistencia, destreza, velocidad);
	}

	@Override
	public String toString() {
		return "Villano [Nombre de Villano=" + nombrePersonaje + "]";
	}

	@Override
	public boolean esHeroe() {
		return false;
	}

	@Override
	public boolean esVillano() {
		return true;
	}

	@Override
	public String getNombreLiga() {
		return null;
	}

}
