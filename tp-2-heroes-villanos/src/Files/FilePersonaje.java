package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

import Composite.Heroe;
import Composite.Personaje;
import Composite.Villano;
import Exceptions.EmptyFileException;
import Exceptions.ExistingCompetitorException;
import Exceptions.FeatureLevelException;
import Main.Main;

public class FilePersonaje {

	public static void cargarPersonajes(String ubicacion) throws FileNotFoundException, IOException {
		int contadorCargados = Main.listaPersonajes.size();
		int contadorLineas = 0;
		File archivo = new File(ubicacion);
		Scanner lector = new Scanner(archivo, StandardCharsets.UTF_8);
		try {
			esArchivoVacio(lector);
			lector.nextLine(); // Ignoramos la primer linea que es el nombre de las columnas
		} catch (EmptyFileException e) {
			System.out.println(e.getMessage());
		}
		while (lector.hasNext()) {
			try {
				contadorLineas++;
				String linea = lector.nextLine();
				String[] datosPersonaje = linea.split("[,]");
				buscarPersonaje(Main.listaPersonajes, datosPersonaje[2].trim());
				if (nivelCaracteristicasValidos(datosPersonaje)) {
					switch (datosPersonaje[0].trim()) {
						case "Héroe":
						case "Heroe":
							Main.listaPersonajes.put(datosPersonaje[2].trim(), new Heroe(datosPersonaje[1].trim(),
									datosPersonaje[2].trim(), Integer.parseInt(datosPersonaje[4].trim()),
									Integer.parseInt(datosPersonaje[5].trim()),
									Integer.parseInt(datosPersonaje[3].trim()),
									Integer.parseInt(datosPersonaje[6].trim())));
							break;
						case "Villano":
							Main.listaPersonajes.put(datosPersonaje[2].trim(), new Villano(datosPersonaje[1].trim(),
									datosPersonaje[2].trim(), Integer.parseInt(datosPersonaje[4].trim()),
									Integer.parseInt(datosPersonaje[5].trim()),
									Integer.parseInt(datosPersonaje[3].trim()),
									Integer.parseInt(datosPersonaje[6].trim())));
							break;
						default:
							FilePersonaje.noSePudoInsertar(linea);
							break;
					}

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Error en delimitadores del archivo");
			} catch (ExistingCompetitorException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (FeatureLevelException e) {
				System.out.println("El valor de las caracteristicas debe ser mayor a cero");
			}
		}
		lector.close();
		System.out.println(String.format("El archivo tenia %d lineas", contadorLineas));
		System.out
				.println(String.format("Se insertaron %d personajes", Main.listaPersonajes.size() - contadorCargados));
	}

	public static void esArchivoVacio(Scanner scanner) throws EmptyFileException {
		if (!scanner.hasNext()) {
			throw new EmptyFileException("El archivo está vacío");
		}
	}

	public static void buscarPersonaje(HashMap<String, Personaje> lista, String nombre)
			throws ExistingCompetitorException {
		if (lista.containsKey(nombre)) {
			throw new ExistingCompetitorException("Personaje duplicado");
		}
	}

	public static boolean nivelCaracteristicasValidos(String[] datosPersonaje) {
		try {
			if (datosPersonaje[3].trim() == null || datosPersonaje[4].trim() == null || datosPersonaje[5].trim() == null
					|| datosPersonaje[6].trim() == null) {
				return false;
			}

			if (Integer.parseInt(datosPersonaje[3].trim()) < 0 || Integer.parseInt(datosPersonaje[4].trim()) < 0
					|| Integer.parseInt(datosPersonaje[5].trim()) < 0
					|| Integer.parseInt(datosPersonaje[6].trim()) < 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("Error en formato de caracteristica");
		}
		return true;
	}

	public static void guardarPersonajes(String ubicacion) throws IOException {
		File archivo = new File(ubicacion);
		FileWriter escritor = new FileWriter(archivo);
		escritor.write("Héroe/Villano, NombreReal, NombrePersonaje, Velocidad, Fuerza, Resistencia, Destreza" + System.getProperty("line.separator"));
		for (Personaje p : Main.listaPersonajes.values()) {
			escritor.write(p.toString() + System.getProperty("line.separator"));
		}
		escritor.close();
	}

	private static void noSePudoInsertar(String linea) {
		System.out.println("No se pudo insertar la linea ");
		System.out.println("-----");
		System.out.println(linea);
		System.out.println("-----");
	}

}
