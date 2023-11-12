package Exceptions;

/* Excepcion para manejar errores leer el archivo de Personajes y Ligas:
 * El archivo no existe
 * El archivo está vacío
 */

public class CompetitorFileEmptyException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CompetitorFileEmptyException(String string) {
		super(string);
	}
}
