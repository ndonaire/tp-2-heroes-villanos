package State;

import Composite.Competidor;

public class VelocidadState extends State {
	
	public VelocidadState(Caracteristica c) {
		super(c);
	}

	@Override
	public boolean siguienteCaracteristica() {
		if (contador == 4) {
			contador = 0;
			return false;
		}
		
		c.cambiarCaracteristica(new FuerzaState (c));
		contador++;
		
		return true;
	}

	@Override
	public int getValorCaracteristica(Competidor c) {
		return c.getVelocidad();
	}


}
