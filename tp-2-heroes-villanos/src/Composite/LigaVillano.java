package Composite;

import State.Caracteristica;

public class LigaVillano extends Liga {

	public LigaVillano(String nombreLiga) {
		super(nombreLiga);
	}

	@Override
	public boolean esGanador(Personaje c2, Caracteristica c) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean agregarCompetidor(Competidor c) throws RuntimeException {
		if (this.competidoresEnLiga.contains(c)) {
			throw new RuntimeException("Ya pertenece a esta liga");
		}

		if (c.getEstaEnAlgunaLiga()) {
			throw new RuntimeException("Ya pertenece a una liga");
		}

		if (!c.esVillano() && !c.esLigaVillano()) {
			throw new RuntimeException("El competidor es un héroe, no puede incluirse en una liga de villanos");
		}
		this.competidoresEnLiga.add(c);
		c.setEstaEnAlgunaLiga(true);
		return true;
	}

}
