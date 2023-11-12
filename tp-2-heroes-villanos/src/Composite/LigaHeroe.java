package Composite;

import Exceptions.AddToLeagueException;

public class LigaHeroe extends Liga {

	public LigaHeroe(String nombreLiga) {
		super(nombreLiga);
	}

	@Override
	public boolean esLigaHeroe() {
		return true;
	}

	@Override
	public boolean esLigaVillano() {
		return false;
	}

	@Override
	public boolean agregarCompetidor(Competidor c) throws AddToLeagueException {
		if (this.getNombre() == c.getNombre()) {
			throw new AddToLeagueException("No puede agregarse la liga a si misma");
		}
		
		if (this.competidoresEnLiga.contains(c)) {
			throw new AddToLeagueException("Ya pertenece a esta liga");
		}

		if (c.getEstaEnAlgunaLiga()) {
			throw new AddToLeagueException("Ya pertenece a una liga");
		}

		if (!c.esHeroe() && !c.esLigaHeroe()) {
			throw new AddToLeagueException("El competidor es un villano, no puede incluirse en una liga de héroes");
		}
		this.competidoresEnLiga.add(c);
		c.setEstaEnAlgunaLiga(true);
		return true;
	}

}
