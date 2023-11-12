package State;

import Composite.Personaje;

public class DestrezaState extends State {

	public DestrezaState(Caracteristica c) {
		super(c);
	}

	@Override
	public boolean siguienteCaracteristica() {
		if (contador == 4) {
			contador = 0;
			return false;
		}

		c.cambiarCaracteristica(new VelocidadState(c));
		contador++;

		return true;
	}

	@Override
	public int getValorCaracteristica(Personaje c) {
		return c.getDestreza();
	}

}
