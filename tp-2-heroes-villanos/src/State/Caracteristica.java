package State;

import Composite.Competidor;

public class Caracteristica {
	
	public State state;
	protected static int contador;
	
	public Caracteristica(int c) {
		switch (c) {
		case 1:
			state = new FuerzaState (this);
			break;
		case 2:
			state = new ResistenciaState (this);
			break;
		case 3:
			state = new DestrezaState (this);
			break;			
		case 4:
			state = new VelocidadState (this);
			break;
		}
		contador = 1;
	}
	
	public void cambiarCaracteristica (State state) {
		this.state = state;
	}
	
	public boolean siguienteCaracteristica () {
		return state.siguienteCaracteristica();
	}
	
	public int getValorCaracteristica (Competidor c) {
		return state.getValorCaracteristica(c);
	}
}
