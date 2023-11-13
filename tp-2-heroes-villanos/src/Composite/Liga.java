package Composite;

import java.util.List;

import Exceptions.AddToLeagueException;
import Exceptions.DeleteCompetitorException;
import Exceptions.FriendlyFireException;
import State.Caracteristica;

import java.util.ArrayList;

public abstract class Liga implements Competidor {

	protected boolean estaEnAlgunaLiga = false;
	protected String nombreLiga;
	protected List<Competidor> competidoresEnLiga;

	public Liga(String nombreLiga) {
		super();
		this.nombreLiga = nombreLiga;
		this.competidoresEnLiga = new ArrayList<Competidor>();
	}

	@Override
	public boolean esHeroe() {
		return false;
	}

	@Override
	public boolean esVillano() {
		return false;
	}

	public abstract boolean esLigaHeroe();

	public abstract boolean esLigaVillano();

	public abstract boolean agregarCompetidor(Competidor c) throws AddToLeagueException;

	public boolean ligaVacia() {
		return this.competidoresEnLiga.isEmpty();
	}

	public boolean eliminarCompetidor(Competidor c) throws DeleteCompetitorException {
		if (!c.getEstaEnAlgunaLiga()) {
			throw new DeleteCompetitorException("No se puede eliminar, no pertenece a ninguna liga");
		}
		if (!this.competidoresEnLiga.contains(c)) {
			throw new DeleteCompetitorException("No se puede eliminar, no pertenece a esta liga");
		}
		this.competidoresEnLiga.remove(c);
		c.setEstaEnAlgunaLiga(false);
		return true;
	}

	public boolean esGanador(Competidor c2, Caracteristica c) throws FriendlyFireException{
		if (this.getClass() == c2.getClass()
                || this instanceof LigaHeroe  && c2 instanceof Heroe
                || this instanceof LigaVillano && c2 instanceof Villano) {
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

	public int getFuerza() {
		if (this.competidoresEnLiga.size() != 0) {
			int sumatoriaFuerza = 0;
			for (Competidor competidor : this.competidoresEnLiga) {
				sumatoriaFuerza += competidor.getFuerza();
			}
			return sumatoriaFuerza / this.competidoresEnLiga.size();
		} else {
			return 0;
		}

	}

	public int getResistencia() {
		if (this.competidoresEnLiga.size() != 0) {
			int sumatoriaResistencia = 0;
			for (Competidor competidor : this.competidoresEnLiga) {
				sumatoriaResistencia += competidor.getResistencia();
			}
			return sumatoriaResistencia / this.competidoresEnLiga.size();
		} else {
			return 0;
		}
	}

	public int getVelocidad() {
		if (this.competidoresEnLiga.size() != 0) {
			int sumatoriaVelocidad = 0;
			for (Competidor competidor : this.competidoresEnLiga) {
				sumatoriaVelocidad += competidor.getVelocidad();
			}
			return sumatoriaVelocidad / this.competidoresEnLiga.size();
		} else {
			return 0;
		}
	}

	public int getDestreza() {
		if (this.competidoresEnLiga.size() != 0) {
			int sumatoriaDestreza = 0;
			for (Competidor competidor : this.competidoresEnLiga) {
				sumatoriaDestreza += competidor.getDestreza();
			}
			return sumatoriaDestreza / this.competidoresEnLiga.size();
		} else {
			return 0;
		}
	}

	public boolean getEstaEnAlgunaLiga() {
		return estaEnAlgunaLiga;
	}

	public void setEstaEnAlgunaLiga(boolean estaEnAlgunaLiga) {
		this.estaEnAlgunaLiga = estaEnAlgunaLiga;
	}

	public String getNombre() {
		return nombreLiga;
	}

	@Override
	public String toString() {
		String s = this.nombreLiga;
        for (Competidor c : this.competidoresEnLiga) {
            s = s + ", " + c.getNombre();
        }
        return s;
	}

}
