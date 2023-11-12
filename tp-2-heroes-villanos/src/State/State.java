package State;

import Composite.Competidor;

public abstract class State {

	Caracteristica c;

	protected static int contador;

	public State(Caracteristica c) {
		this.c = c;
	}

	public abstract boolean siguienteCaracteristica();

	public abstract int getValorCaracteristica(Competidor c);
	
}
