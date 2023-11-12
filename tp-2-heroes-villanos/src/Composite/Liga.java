package Composite;

import java.util.List;

import Exceptions.AddToLeagueException;
import Exceptions.DeleteCompetitorException;
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

	public boolean eliminarCompetidor(Competidor c) throws DeleteCompetitorException {
		if (!c.getEstaEnAlgunaLiga()) {
			throw new DeleteCompetitorException("No se puede eliminar, no pertenece a ninguna liga");
		}
		if (this.competidoresEnLiga.contains(c)) {
			throw new DeleteCompetitorException("No se puede eliminar, no pertenece a esta liga");
		}
		this.competidoresEnLiga.remove(c);
		c.setEstaEnAlgunaLiga(false);
		return true;
	}

	public boolean esGanador(Competidor competidor, Caracteristica caracteristica) {
		do {
			if (caracteristica.getValorCaracteristica(this) > caracteristica.getValorCaracteristica(competidor)) {
				return true;
			}
		} while (caracteristica.siguienteCaracteristica());

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

	public String getNombreLiga() {
		return nombreLiga;
	}

	@Override
	public String toString() {
		return "Liga: " + this.nombreLiga + "[" + this.competidoresEnLiga + "]";
	}

}
