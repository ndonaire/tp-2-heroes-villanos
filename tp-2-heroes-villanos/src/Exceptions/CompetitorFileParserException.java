package Exceptions;

/* Excepcion para manejar errores procesar el archivo de Personajes y Ligas:
 * El archivo no está correctamente parseado por sus delimitadores o hay un caracter inválido
 */

public class CompetitorFileParserException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CompetitorFileParserException(String string) {
		super(string);
	}

}
