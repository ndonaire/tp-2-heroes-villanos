package Files;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Main.Main;

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

	@Test
	public void testCargarPersonajesOK() throws IOException {
		FilePersonaje.cargarPersonajes("PersonajesOK.txt");
		assertEquals("El archivo tenia 3 lineas\r\n" + "Se insertaron 3 personajes\r\n", out.toString());
	}

	@Test(expected = FileNotFoundException.class)
	public void testCargarPersonajesArchivoNoEncontrado() throws IOException {
		String path = "";
		FilePersonaje.cargarPersonajes(path);
	}

	@Test
	public void testCargarPersonajesArchivoVacio() throws IOException {
		FilePersonaje.cargarPersonajes("PersonajesVacio.txt");
		assertEquals("El archivo está vacío\r\n" + "El archivo tenia 0 lineas\r\n" + "Se insertaron 0 personajes\r\n",
				out.toString());
	}

	@Test
	public void testCargarPersonajesParserError() throws IOException {
		Main.listaPersonajes.clear();
		FilePersonaje.cargarPersonajes("PersonajesParserError.txt");
		assertEquals("Error en delimitadores del archivo\r\n" + "El archivo tenia 2 lineas\r\n"
				+ "Se insertaron 1 personajes\r\n", out.toString());
	}

	@Test
	public void testCargarPersonajesDuplicados() throws IOException {
		Main.listaPersonajes.clear();
		FilePersonaje.cargarPersonajes("PersonajesDuplicados.txt");
		assertEquals("Personaje duplicado\r\n" + "El archivo tenia 2 lineas\r\n" + "Se insertaron 1 personajes\r\n",
				out.toString());
	}

	@Test
	public void testCargarPersonajesErrorCaracteristica() throws IOException {
		Main.listaPersonajes.clear();
		FilePersonaje.cargarPersonajes("PersonajeCaracteristicaError.txt");
		assertEquals(
				"El archivo tenia 2 lineas\r\n"
				+ "Se insertaron 1 personajes\r\n",
				out.toString());
	}

}
