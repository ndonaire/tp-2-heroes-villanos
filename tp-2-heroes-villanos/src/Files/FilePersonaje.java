package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Composite.Heroe;
import Composite.Personaje;
import Composite.Villano;
import Main.Main;

public class FilePersonaje {
    public static void cargarPersonajes(String ubicacion) throws FileNotFoundException {
        int contadorCargados = Main.listaPersonajes.size();
        int contadorLineas = 0;
        File archivo = new File(ubicacion);
        Scanner lector = new Scanner(archivo);
        while (lector.hasNextLine()) {
            contadorLineas++;
            String linea = lector.nextLine();
            String[] datosPersonaje = linea.split("[,]");
            // datosPersonaje [0] -> Heroe/Villano
            // datosPersonaje [1] -> Nombre Real
            // datosPersonaje [2] -> Nombre Personaje
            // datosPersonaje [3] -> Velocidad
            // datosPersonaje [4] -> Fuerza
            // datosPersonaje [5] -> Resistencia
            // datosPersonaje [6] -> Destreza

            try {
                switch (datosPersonaje[0].trim()) {
                    case "Héroe":
                    case "Heroe":
                        Main.listaPersonajes.put(datosPersonaje[2].trim(),
                                new Heroe(
                                        datosPersonaje[1].trim(),
                                        datosPersonaje[2].trim(),
                                        Integer.parseInt(datosPersonaje[4].trim()),
                                        Integer.parseInt(datosPersonaje[5].trim()),
                                        Integer.parseInt(datosPersonaje[3].trim()),
                                        Integer.parseInt(datosPersonaje[6].trim())));
                        break;
                    case "Villano":
                        Main.listaPersonajes.put(datosPersonaje[2].trim(),
                                new Villano(
                                        datosPersonaje[1].trim(),
                                        datosPersonaje[2].trim(),
                                        Integer.parseInt(datosPersonaje[4].trim()),
                                        Integer.parseInt(datosPersonaje[5].trim()),
                                        Integer.parseInt(datosPersonaje[3].trim()),
                                        Integer.parseInt(datosPersonaje[6].trim())));
                        break;
                    default:
                        FilePersonaje.noSePudoInsertar(linea);
                        break;
                }
            } catch (NumberFormatException e) {
                FilePersonaje.noSePudoInsertar(linea);
            }

        }
        lector.close();
        System.out.println(String.format("El archivo tenia %d lineas", contadorLineas));
        System.out
                .println(String.format("Se insertaron %d personajes", Main.listaPersonajes.size() - contadorCargados));
    }

    public static void guardarPersonajes(String ubicacion) throws IOException {
        File archivo = new File(ubicacion);
        FileWriter escritor = new FileWriter(archivo);
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
