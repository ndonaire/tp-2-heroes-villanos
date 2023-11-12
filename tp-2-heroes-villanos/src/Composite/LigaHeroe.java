package Composite;

import State.Caracteristica;

public class LigaHeroe extends Liga {

	public LigaHeroe(String nombreLiga) {
		super(nombreLiga);
	}

	@Override
	public boolean esGanador(Personaje c2, Caracteristica c) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean agregarCompetidor(Competidor c) throws RuntimeException {
		if (this.competidoresEnLiga.contains(c)) {
			throw new RuntimeException("Ya pertenece a esta liga");
		}

		if (c.getEstaEnAlgunaLiga()) {
			throw new RuntimeException("Ya pertenece a una liga");
		}

		if (!c.esHeroe() && !c.esLigaHeroe()) {
			throw new RuntimeException("El competidor es un villano, no puede incluirse en una liga de héroes");
		}
		this.competidoresEnLiga.add(c);
		c.setEstaEnAlgunaLiga(true);
		return true;
	}

}
