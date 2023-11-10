package Composite;
import State.Habilidad;

public class Heroe extends Personaje{
		
	protected Habilidad habilidad;
	protected int idTipoCompetidor;
	protected int nombreCompetidor;
	protected boolean estaEnAlgunaLiga;
	
	public Heroe(Habilidad habilidad, int idTipoCompetidor, int nombreCompetidor, boolean estaEnAlgunaLiga) {
		super();
		this.habilidad = habilidad;
		this.idTipoCompetidor = idTipoCompetidor;
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

}
