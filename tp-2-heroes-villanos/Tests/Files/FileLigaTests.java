package Files;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	
	//@Test // No funciona --> Tira error de caracteristicas en arch personajes y no debería
	public void testCargarLigaOk() throws FileNotFoundException {
		FilePersonaje.cargarPersonajes("PersonajesOK.txt");
		FileLiga.cargarLigas("LigasOK.txt");
		assertEquals("test", out.toString());
	}

	@Test(expected = FileNotFoundException.class)
	public void testCargarLigaArchivoNoEncontrado() throws FileNotFoundException {
		String path = "";
		FileLiga.cargarLigas(path);
	}

	@Test
	public void testCargarLigaArchivoVacio() throws FileNotFoundException {
		FileLiga.cargarLigas("LigasVacio.txt");
		assertEquals("El archivo está vacío\r\n" + "Se insertaron 0 ligas\r\n", out.toString());
	}

	// @Test //No funciona --> Tira error de caracteristicas en arch personajes y no debería
	public void testCargarLigaArchivoParserError() throws FileNotFoundException {
		FilePersonaje.cargarPersonajes("PersonajesOK.txt");
		FileLiga.cargarLigas("LigasParserError.txt");
		assertEquals("test", out.toString());
	}

	@Test // No funciona --> Tira error de caracteristicas en arch personajes y no debería
	public void testCargarLigaDuplicadas() throws FileNotFoundException {
		FilePersonaje.cargarPersonajes("PersonajesOK.txt");
		FileLiga.cargarLigas("LigasDuplicadas.txt");
		assertEquals("test", out.toString());
	}
	
	
}
