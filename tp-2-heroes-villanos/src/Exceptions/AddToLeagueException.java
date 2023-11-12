package Exceptions;

/* Excepcion para manejar errores al agregar competidores a Ligas:
 * Agregar un heroe a una liga de villanos
 * Agregar un villano a una liga de heroes
 * Agregar un competidor o liga a una segunda liga (Solo puede pertenecer a una)
 * Agregar un completidor o liga a la misma liga a la que ya pertenece
 */

public class AddToLeagueException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AddToLeagueException(String string) {
		super(string);
	}
}
