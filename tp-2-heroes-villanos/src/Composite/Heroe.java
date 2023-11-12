package Composite;

public class Heroe extends Personaje {

	public Heroe(String nombreReal, String nombrePersonaje, int fuerza, int resistencia, int destreza, int velocidad) {
		super(nombreReal, nombrePersonaje, fuerza, resistencia, destreza, velocidad);
	}

	@Override
	public String toString() {
		return String.format("Heroe  , %-25s, %-25s, %4d, %4d, %4d, %4d", this.getNombreReal(),
				this.getNombre(), this.getVelocidad(), this.getFuerza(), this.getResistencia(),
				this.getDestreza());
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