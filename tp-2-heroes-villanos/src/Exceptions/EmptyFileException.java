package Exceptions;

/* Excepcion para manejar errores leer el archivo de Personajes y Ligas:
 * El archivo está vacío
 */

public class EmptyFileException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EmptyFileException(String string) {
		super(string);
	}
}
