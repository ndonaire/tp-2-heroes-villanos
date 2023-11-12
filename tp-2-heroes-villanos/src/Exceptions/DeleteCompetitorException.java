package Exceptions;

/* Excepcion para manejar errores al eliminar un competidor de una liga:
 * Eliminar competidor que no pertenece a ninguna liga
 * Eliminar competidor que no pertenece a la liga de la cual se desea eliminar
 */

public class DeleteCompetitorException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DeleteCompetitorException(String string) {
		super(string);
	}
}
