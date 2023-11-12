package Composite;

import State.Caracteristica;

public abstract class Personaje implements Competidor {

	protected boolean estaEnAlgunaLiga = false;
	protected String nombreReal;
	protected String nombrePersonaje;

	private int fuerza;
	private int resistencia;
	private int destreza;
	private int velocidad;

	public Personaje(String nombreReal, String nombrePersonaje, int fuerza, int resistencia, int destreza,
			int velocidad) {
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

	public boolean esGanador(Competidor c2, Caracteristica c) {
		do {
			if (c.getValorCaracteristica(this) > c.getValorCaracteristica(c2)) {
				return true;
			}
			if (c.getValorCaracteristica(this) < c.getValorCaracteristica(c2)) {
				return false;
			}
		} while (c.siguienteCaracteristica());

		return false;
	}

	public abstract String toString();

	public int getFuerza() {
		return fuerza;
	}

	public int getResistencia() {
		return resistencia;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getDestreza() {
		return destreza;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public boolean getEstaEnAlgunaLiga() {
		return estaEnAlgunaLiga;
	}

	public void setEstaEnAlgunaLiga(boolean estaEnAlgunaLiga) {
		this.estaEnAlgunaLiga = estaEnAlgunaLiga;
	}

}
