package Composite;
import State.Habilidad;

public class Villano extends Personaje{
	
	protected Habilidad habilidad;
	protected int nombreCompetidor;
	protected boolean estaEnAlgunaLiga;
	
	public Villano(Habilidad habilidad, int nombreCompetidor, boolean estaEnAlgunaLiga) {
		super();
		this.habilidad = habilidad;
		this.nombreCompetidor = nombreCompetidor;
		this.estaEnAlgunaLiga = estaEnAlgunaLiga;
	}

	@Override
	public boolean esHeroe() {
		return false;
	}

	@Override
	public boolean esVillano() {
		return true;
	}
	
}
