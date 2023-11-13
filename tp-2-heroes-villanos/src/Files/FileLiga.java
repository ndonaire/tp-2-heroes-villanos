package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import Composite.Heroe;
import Composite.Liga;
import Composite.LigaHeroe;
import Composite.LigaVillano;
import Composite.Personaje;
import Exceptions.AddToLeagueException;
import Exceptions.EmptyFileException;
import Exceptions.ExistingCompetitorException;
import Exceptions.ExistingLeagueException;
import Main.Main;

public class FileLiga {
	public static void cargarLigas(String ubicacion) throws FileNotFoundException {
        int contadorCargados = 0;
        File archivo = new File(ubicacion);
        Scanner lector = new Scanner(archivo);
        try {
        	esArchivoVacio(lector);
        while (lector.hasNextLine()) {
            String lineaLiga = lector.nextLine();
            String[] miembrosLiga = lineaLiga.split("[,]");
            buscarLiga(Main.listaLigas,miembrosLiga[0].trim());
            Liga nuevaLiga = null;
            if (miembrosLiga.length > 1) {
                Personaje primerPer = Main.listaPersonajes.get(miembrosLiga[1].trim());

                if (primerPer != null) {
                    if (primerPer instanceof Heroe) {
                        nuevaLiga = new LigaHeroe(miembrosLiga[0].trim());
                    } else {
                        nuevaLiga = new LigaVillano(miembrosLiga[0].trim());
                    }
                } else {
                    Liga primerLiga = Main.listaLigas.get(miembrosLiga[1].trim());
                    if (primerLiga != null) {
                        if (primerLiga instanceof LigaHeroe) {
                            nuevaLiga = new LigaHeroe(miembrosLiga[0].trim());
                        } else {
                            nuevaLiga = new LigaVillano(miembrosLiga[0].trim());
                        }
                    }
                }

                miembrosLiga = Arrays.copyOfRange(miembrosLiga, 1, miembrosLiga.length);
                if (nuevaLiga != null) {
                    for (String miembro : miembrosLiga) {
                        try {
                            Personaje p = Main.listaPersonajes.get(miembro.trim());
                            if (p != null) {
                                nuevaLiga.agregarCompetidor(p);
                            } else {
                                Liga l = Main.listaLigas.get(miembro.trim());
                                if (l != null) {
                                    nuevaLiga.agregarCompetidor(l);
                                }
                            }
                        } catch (AddToLeagueException e) {
                            System.out.println(e.getMessage());
                            FileLiga.noSePudoInsertar(lineaLiga);
                        }
                    }
                    if (!nuevaLiga.ligaVacia()) {
                        Main.listaLigas.put(nuevaLiga.getNombre(), nuevaLiga);
                        contadorCargados++;
                    } else {
                        FileLiga.noSePudoInsertar(lineaLiga);
                    }
                }
            }
        }
	}catch (EmptyFileException e) {
		System.out.println(e.getMessage());
	}catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Error en delimitadores del archivo");
	} catch (ExistingLeagueException e) {
		System.out.println(e.getMessage());
	}
        lector.close();
        System.out.println(String.format("Se insertaron %d ligas", contadorCargados));
    }

	public static void esArchivoVacio(Scanner scanner) throws EmptyFileException {
		if (!scanner.hasNext()) {
			throw new EmptyFileException("El archivo está vacío");
		}
	}
	
	public static void buscarLiga(LinkedHashMap<String, Liga> listaLigas, String nombre)
			throws ExistingLeagueException {
		if (listaLigas.containsKey(nombre)) {
			throw new ExistingLeagueException("Liga duplicada");
		}
	}


	public static void guardarLigas(String ubicacion) throws IOException {
		File archivo = new File(ubicacion);
		FileWriter escritor = new FileWriter(archivo);

		for (Liga l : Main.listaLigas.values()) {
			escritor.write(l.toString() + System.getProperty("line.separator"));
		}
		escritor.close();
	}

	private static void noSePudoInsertar(String linea) {
		System.out.println("No se pudo insertar la linea :");
		System.out.println("-----");
		System.out.println(linea);
		System.out.println("-----");
	}

}
