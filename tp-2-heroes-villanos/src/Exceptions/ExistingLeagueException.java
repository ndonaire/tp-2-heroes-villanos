package Exceptions;

/* Excepcion para manejar errores al crear una Liga que ya existe:
 * Se crea una Liga que posee el mismo nombre que otra creada anteriormente
 */

public class ExistingLeagueException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExistingLeagueException(String string) {
		super(string);
	}
}
