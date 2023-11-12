package Composite;

import State.Caracteristica;

public abstract class Personaje implements Competidor {

	protected boolean estaEnAlgunaLiga = false;
	protected String nombreReal;
	protected String nombrePersonaje;

	private int fuerza;
	private int resistencia;
	private int velocidad;
	private int destreza;

	public Personaje(String nombreReal, String nombrePersonaje, int fuerza, int resistencia, int velocidad,
			int destreza) {
		super();
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.velocidad = velocidad;
		this.destreza = destreza;
	}

	@Override
	public abstract boolean esHeroe();

	@Override
	public abstract boolean esVillano();

	public boolean esLigaHeroe() {
		return false;
	}

	public boolean esLigaVillano() {
		return false;
	}

	public boolean esGanador(Personaje c2, Caracteristica c) {
		do {
			if (c.getValorCaracteristica(this) > c.getValorCaracteristica(c2)) {
				return true;
			}
		} while (c.siguienteCaracteristica());

		return false;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}

	public boolean getEstaEnAlgunaLiga() {
		return estaEnAlgunaLiga;
	}

	public void setEstaEnAlgunaLiga(boolean estaEnAlgunaLiga) {
		this.estaEnAlgunaLiga = estaEnAlgunaLiga;
	}

}
