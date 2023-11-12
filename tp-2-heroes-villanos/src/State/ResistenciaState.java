package State;

import Composite.Personaje;

public class ResistenciaState extends State {

	public ResistenciaState(Caracteristica c) {
		super(c);
	}

	@Override
	public boolean siguienteCaracteristica() {
		if (contador == 4) {
			contador = 0;
			return false;
		}

		c.cambiarCaracteristica(new DestrezaState(c));
		contador++;

		return true;
	}

	@Override
	public int getValorCaracteristica(Personaje c) {
		return c.getResistencia();
	}

}
