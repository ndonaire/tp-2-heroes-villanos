package Composite;

import Exceptions.AddToLeagueException;

public class LigaVillano extends Liga {

	public LigaVillano(String nombreLiga) {
		super(nombreLiga);
	}

	@Override
	public boolean esLigaHeroe() {
		return false;
	}

	@Override
	public boolean esLigaVillano() {
		return true;
	}

	@Override
	public boolean agregarCompetidor(Competidor c) throws AddToLeagueException {
		if (this.getNombreLiga() == c.getNombreLiga()) {
			throw new AddToLeagueException("No puede agregarse la liga a si misma");
		}
		
		if (this.competidoresEnLiga.contains(c)) {
			throw new AddToLeagueException("Ya pertenece a esta liga");
		}

		if (c.getEstaEnAlgunaLiga()) {
			throw new AddToLeagueException("Ya pertenece a una liga");
		}

		if (!c.esVillano() && !c.esLigaVillano()) {
			throw new AddToLeagueException("El competidor es un héroe, no puede incluirse en una liga de villanos");
		}
		this.competidoresEnLiga.add(c);
		c.setEstaEnAlgunaLiga(true);
		return true;
	}

}
