package Composite;

public class Villano extends Personaje {

	public Villano(String nombreReal, String nombrePersonaje, int fuerza, int resistencia, int velocidad,
			int destreza) {
		super(nombreReal, nombrePersonaje, fuerza, resistencia, velocidad, destreza);
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
