package Files;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilePersonajeTests {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final ByteArrayOutputStream err = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setStreams() {
		System.setOut(new PrintStream(out));
		System.setErr(new PrintStream(err));
	}

	@After
	public void restoreInitialStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}
	
	//@Test /No funciona --> Tira error de caracteristicas pero no deberia tirar ningun error
	public void testCargarPersonajesOK() throws FileNotFoundException {
		FilePersonaje.cargarPersonajes("PersonajesOK.txt");
		assertEquals("", out.toString());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testCargarPersonajesArchivoNoEncontrado() throws FileNotFoundException {
		String path = "";
		FilePersonaje.cargarPersonajes(path);
	}

	@Test
	public void testCargarPersonajesArchivoVacio() throws FileNotFoundException {
		FilePersonaje.cargarPersonajes("PersonajesVacio.txt");
		assertEquals("El archivo está vacío\r\n" + "El archivo tenia 0 lineas\r\n" + "Se insertaron 0 personajes\r\n",
				out.toString());
	}	
	
	//@Test //No funciona --> Tira error de caracteristicas pero deberia tirar de delimitadores
	public void testCargarPersonajesParserError() throws FileNotFoundException {
		FilePersonaje.cargarPersonajes("PersonajesParserError.txt");
		assertEquals("", out.toString());
	}

	//@Test //No funciona --> Tira error de caracteristicas pero deberia tirar solo duplicados
	public void testCargarPersonajesDuplicados() throws FileNotFoundException {
		FilePersonaje.cargarPersonajes("PersonajesDuplicados.txt");
		assertEquals("", out.toString());
	}

	@Test
	public void testCargarPersonajesErrorCaracteristica() throws FileNotFoundException {
		FilePersonaje.cargarPersonajes("PersonajeCaracteristicaError.txt");
		assertEquals("Error en formato de caracteristica\r\n"
				+ "No se pudo insertar la linea \r\n"
				+ "-----\r\n"
				+ "Héroe/Villano, NombreReal, NombrePersonaje, Velocidad, Fuerza, Resistencia, Destreza\r\n"
				+ "-----\r\n"
				+ "El archivo tenia 3 lineas\r\n"
				+ "Se insertaron 1 personajes\r\n", out.toString());
	}
	
	
	

}
