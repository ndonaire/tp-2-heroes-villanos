package Composite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

import Exceptions.FeatureLevelException;
import Exceptions.FriendlyFireException;
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
			int velocidad) throws FeatureLevelException {
		if (fuerza < 0 || resistencia < 0 || destreza < 0 || velocidad < 0) {
			throw new FeatureLevelException("No se pueden cargar características menores a cero");
		}
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

	public boolean esGanador(Competidor c2, Caracteristica c) throws FriendlyFireException {
		if (this.getClass() == c2.getClass() || this instanceof Heroe && c2 instanceof LigaHeroe
				|| this instanceof Villano && c2 instanceof LigaVillano) {
			throw new FriendlyFireException("No se puede combatir entre compañeros");
		}
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

	public void mostrarVencedores(LinkedHashMap<String, Liga> ligas, HashMap<String, Personaje> personajes,
			Caracteristica c) {
		System.out.println("Lista de vencedores");
		System.out.println("*******************");

		System.out.println("Lista de ligas");
		System.out.println("-------------------");

		for (Liga l : ligas.values()) {
			try {
				if (!this.esGanador(l, c)) {
					System.out.println(String.format(l.getNombre()));
				}
			} catch (FriendlyFireException e) {
				// Probamos aunque sean compañeros como el error no surge de la entrada del
				// usuario lo ignoramos
			}

		}

		System.out.println("-------------------");
		System.out.println("Lista de personajes");
		System.out.println("-------------------");

		for (Personaje p : personajes.values()) {
			try {
				if (!this.esGanador(p, new Caracteristica(1))) {
					System.out.println(String.format(p.getNombre()));
				}
			} catch (FriendlyFireException e) {
				// Probamos aunque sean compañeros como el error no surge de la entrada del
				// usuario lo ignoramos
			}

		}
		System.out.println("-------------------");
	}
	
	public static void ordenarLista(ArrayList<Personaje> lista, ArrayList<String> aComparar) {
		ArrayList<Comparator<Personaje>> comparators = new ArrayList<Comparator<Personaje>>(4);
		for (String caracteristica : aComparar) {
			if (comparators.size() < 4) {
				switch (caracteristica) {
					case "Velocidad":
						comparators.add(Comparator.comparing(Personaje::getVelocidad));
						break;
					case "Fuerza":
						comparators.add(Comparator.comparing(Personaje::getFuerza));
						break;
					case "Resistencia":
						comparators.add(Comparator.comparing(Personaje::getResistencia));
						break;
					case "Destreza":
						comparators.add(Comparator.comparing(Personaje::getDestreza));
						break;
					default:
						break;
				}
			}
		}

		int tamComparators = comparators.size();

		if (tamComparators == 1) {
			lista.sort(comparators.get(0));
		}
		if (tamComparators == 2) {
			lista.sort(comparators.get(0).thenComparing(comparators.get(1)));
		}
		if (tamComparators == 3) {
			lista.sort(comparators.get(0)
					.thenComparing(comparators.get(1).thenComparing(comparators.get(2))));
		}
		if (tamComparators == 4) {
			lista.sort(comparators.get(0).thenComparing(comparators.get(1)
					.thenComparing(comparators.get(2).thenComparing(comparators.get(3)))));
		}
	}
	
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

	public String getNombre() {
		return nombrePersonaje;
	}

	public boolean getEstaEnAlgunaLiga() {
		return estaEnAlgunaLiga;
	}

	public void setEstaEnAlgunaLiga(boolean estaEnAlgunaLiga) {
		this.estaEnAlgunaLiga = estaEnAlgunaLiga;
	}

	public abstract String toString();
}
