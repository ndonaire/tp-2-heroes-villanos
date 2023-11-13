package Composite;

import Exceptions.FriendlyFireException;
import State.Caracteristica;

public interface Competidor {

	public boolean esGanador(Competidor c2, Caracteristica c) throws FriendlyFireException;

	public boolean esHeroe();

	public boolean esVillano();

	public boolean esLigaHeroe();

	public boolean esLigaVillano();

	public int getFuerza();

	public int getResistencia();

	public int getVelocidad();

	public int getDestreza();
	
	public String getNombre();
	
	public boolean getEstaEnAlgunaLiga();

	public void setEstaEnAlgunaLiga(boolean b);

}
