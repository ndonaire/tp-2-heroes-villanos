package Composite;

import State.Habilidad;

public abstract class Personaje implements Competidor{
	
	protected Habilidad habilidad;
	protected int idTipoCompetidor;
	protected int nombreCompetidor;
	protected boolean estaEnAlgunaLiga;
	
	@Override
	public abstract boolean esHeroe();

	@Override
	public abstract boolean esVillano();

	@Override
	public boolean esLigaHeroe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esLigaVillano() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean esGanador() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getDestrezaValor() {
		//return this.habilidad.getDestreza();
		return 0;
	}

	public int getFuerzaValor() {
		//return this.habilidad.getFuerza();
		return 0;
	}

	public int getVelocidadValor() {
		//return this.habilidad.getVelocidad();
		return 0;
	}

	public int getResistenciaValor() {
		//return this.habilidad.getResistencia();
		return 0;
	}

	public Habilidad getHabilidad() {
		return this.habilidad;
	}

}
