package Exceptions;

/* Excepcion para manejar errores al crear un competidor que ya existe:
 * Se crea un competidor que posee el mismo nombre de Personaje que otro agregado anteriormente
 */

public class ExistingCompetitorException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExistingCompetitorException(String string) {
		super(string);
	}
}
