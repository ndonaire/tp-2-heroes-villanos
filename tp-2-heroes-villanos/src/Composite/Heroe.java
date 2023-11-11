package Composite;
import State.Habilidad;

public class Heroe extends Personaje{
		
	protected Habilidad habilidad;
	protected int nombreCompetidor;
	protected boolean estaEnAlgunaLiga;
	
	public Heroe(Habilidad habilidad, int nombreCompetidor, boolean estaEnAlgunaLiga) {
		super();
		this.habilidad = habilidad;
		this.nombreCompetidor = nombreCompetidor;
		this.estaEnAlgunaLiga = estaEnAlgunaLiga;
	}

	@Override
	public boolean esHeroe() {
		return true;
	}

	@Override
	public boolean esVillano() {
		return false;
	}

}
