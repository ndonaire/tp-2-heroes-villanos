package Files;

import java.io.IOException;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Main.Main;

public class FileLigaTests {

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
	public void testCargarLigaOk() throws IOException {
		FilePersonaje.cargarPersonajes("PersonajesOK.txt");
		FileLiga.cargarLigas("LigasOK.txt");
		assertEquals("El archivo tenia 3 lineas\r\n"
				+ "Se insertaron 3 personajes\r\n"
				+ "Se insertaron 4 ligas\r\n", out.toString());
	}

	@Test(expected = FileNotFoundException.class)
	public void testCargarLigaArchivoNoEncontrado() throws IOException {
		String path = "";
		FileLiga.cargarLigas(path);
	}

	@Test
	public void testCargarLigaArchivoVacio() throws IOException {
		FileLiga.cargarLigas("LigasVacio.txt");
		assertEquals("El archivo está vacío\r\n" + "Se insertaron 0 ligas\r\n", out.toString());
	}

	@Test 
	public void testCargarLigaArchivoParserError() throws IOException {
		Main.listaPersonajes.clear();
	    Main.listaLigas.clear();
		FilePersonaje.cargarPersonajes("PersonajesOK.txt");
		FileLiga.cargarLigas("LigasParserError.txt");
		assertEquals("El archivo tenia 3 lineas\r\n"
				+ "Se insertaron 3 personajes\r\n"
				+ "Se insertaron 1 ligas\r\n", out.toString());
	}

	@Test 
	public void testCargarLigaDuplicadas() throws IOException {
		Main.listaPersonajes.clear();
	    Main.listaLigas.clear();
		FilePersonaje.cargarPersonajes("PersonajesOK.txt");
		FileLiga.cargarLigas("LigasDuplicadas.txt");
		assertEquals("El archivo tenia 3 lineas\r\n"
				+ "Se insertaron 3 personajes\r\n"
				+ "Liga duplicada\r\n"
				+ "Se insertaron 2 ligas\r\n", out.toString());
	}
	
	
}
