package Composite;

import Exceptions.FeatureLevelException;

public class Villano extends Personaje {

	public Villano(String nombreReal, String nombrePersonaje, int fuerza, int resistencia, int destreza, int velocidad)
			throws FeatureLevelException {
		super(nombreReal, nombrePersonaje, fuerza, resistencia, destreza, velocidad);
	}

	@Override
	public String toString() {
		return String.format("Villano, %-25s, %-25s, %4d, %4d, %4d, %4d", this.getNombreReal(), this.getNombre(),
				this.getVelocidad(), this.getFuerza(), this.getResistencia(), this.getDestreza());
	}

	@Override
	public boolean esHeroe() {
		return false;
	}

	@Override
	public boolean esVillano() {
		return true;
	}

}
