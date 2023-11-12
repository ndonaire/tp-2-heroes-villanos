package State;

import Composite.Competidor;

public class FuerzaState extends State {

	public FuerzaState(Caracteristica c) {
		super(c);
	}

	@Override
	public boolean siguienteCaracteristica() {
		if (contador == 4) {
			contador = 0;
			return false;
		}

		c.cambiarCaracteristica(new ResistenciaState(c));
		contador++;
		
		return true;
	}

	@Override
	public int getValorCaracteristica(Competidor c) {
		return c.getFuerza();
	}

}
