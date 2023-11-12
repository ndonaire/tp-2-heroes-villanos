package UserInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Composite.Heroe;
import Composite.Liga;
import Composite.LigaHeroe;
import Composite.LigaVillano;
import Composite.Personaje;
import Composite.Villano;
import Files.FileLiga;
import Files.FilePersonaje;
import Main.Main;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menuPrincipal() {
        UserInterface.clearScreen();
        String op = "1.Administracion de Personajes\n" +
                "2.Administracion de Ligas\n" +
                "3.Realizacion de Combates\n" +
                "4.Reportes\n" +
                "5.Salir\n";
        int opcion = UserInterface.validarEntero(op, 5);
        switch (opcion) {
            case 1:
                UserInterface.administracionDePersonajes();
                break;
            case 2:
                UserInterface.administracionDeLigas();
                break;
            case 3:
                UserInterface.realizacionDeCombates();
                break;
            case 4:
                UserInterface.reportes();
                break;
            case 5:
                return;
            default:
                UserInterface.menuPrincipal();
                break;
        }
    }

    private static void administracionDePersonajes() {
        UserInterface.clearScreen();
        String op = "1.Cargar personajes desde archivo\n" +
                "2.Crear personaje\n" +
                "3.Listar personajes\n" +
                "4.Guardar en archivo todos los personajes\n" +
                "5.Menu Principal\n";
        int opcion = UserInterface.validarEntero(op, 5);
        switch (opcion) {
            case 1:
                UserInterface.cargarPersonajesArchivo();
                UserInterface.administracionDePersonajes();
                break;
            case 2:
                UserInterface.crearPersonaje();
                UserInterface.administracionDePersonajes();
                break;
            case 3:
                UserInterface.mostrarMainPersonajes();
                UserInterface.administracionDePersonajes();
                break;
            case 4:
                UserInterface.guardarPersonajeArchivo();
                UserInterface.menuPrincipal();
                break;
            case 5:
                UserInterface.menuPrincipal();
                break;
            default:
                UserInterface.administracionDePersonajes();
                break;
        }
    }

    private static void administracionDeLigas() {
        UserInterface.clearScreen();
        String op = "1.Cargar ligas desde archivo\n" +
                "2.Crear liga\n" +
                "3.Listar ligas\n" +
                "4.Guardar en archivo todas las ligas\n" +
                "5.Menu Principal\n";
        int opcion = UserInterface.validarEntero(op, 5);
        switch (opcion) {
            case 1:
                UserInterface.cargarLigasArchivo();
                UserInterface.administracionDeLigas();
                break;
            case 2:
                UserInterface.crearLiga();
                UserInterface.administracionDeLigas();
                break;
            case 3:
                UserInterface.mostrarMainLigas();
                UserInterface.administracionDeLigas();
                break;
            case 4:
                UserInterface.guardarLigasArchivo();
                UserInterface.menuPrincipal();
                break;
            case 5:
                UserInterface.menuPrincipal();
                break;
            default:
                UserInterface.administracionDeLigas();
                break;
        }
    }

    private static void realizacionDeCombates() {
        UserInterface.clearScreen();
        String op = "1.Personaje contra liga\n" +
                "2.Liga contra liga\n" +
                "3.Menu Principal\n";
        int opcion = UserInterface.validarEntero(op, 3);
        switch (opcion) {
            case 1:
                // UserInterface.combatePersonajeContraLiga();
                UserInterface.realizacionDeCombates();
                break;
            case 2:
                // UserInterface.combateLigaContraLiga();
                UserInterface.realizacionDeCombates();
                break;
            case 3:
                UserInterface.menuPrincipal();
                break;
            default:
                UserInterface.realizacionDeCombates();
                break;
        }
    }

    private static void reportes() {
        UserInterface.clearScreen();
        String op = "1.Personaje contra liga\n" +
                "2.Liga contra liga\n" +
                "3.Menu Principal\n";
        int opcion = UserInterface.validarEntero(op, 3);
        switch (opcion) {
            case 1:
                // UserInterface.competidoresQueVencen();
                UserInterface.reportes();
                break;
            case 2:
                // UserInterface.mostrarListaOrdenada();
                UserInterface.reportes();
                break;
            case 3:
                UserInterface.menuPrincipal();
                break;
            default:
                UserInterface.reportes();
                break;
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void esperarConsola() {
        System.out.println("Presiona enter para continuar");
        UserInterface.scanner.nextLine();
    }

    private static int validarEntero(String menu, int maximo) {
        int opcion = 0;
        boolean esValido = false;

        while (!esValido) {
            UserInterface.clearScreen();
            System.out.println(menu);
            if (UserInterface.scanner.hasNextInt()) {
                opcion = UserInterface.scanner.nextInt();
                if (opcion >= 1 && opcion <= maximo) {
                    esValido = true;
                }

            } else {
                scanner.nextLine();
            }
        }
        scanner.nextLine(); // consume el \n que queda
        return opcion;
    }

    private static void cargarPersonajesArchivo() {
        UserInterface.clearScreen();
        System.out.println("Ingrese la ubicacion: ");
        String ubicacionEntrada = UserInterface.scanner.nextLine();
        try {
            FilePersonaje.cargarPersonajes(ubicacionEntrada);

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no pudo ser encontrado");
            UserInterface.esperarConsola();
            UserInterface.administracionDePersonajes();
        }
        UserInterface.esperarConsola();
    }

    private static void crearPersonaje() {
        UserInterface.clearScreen();
        System.out.println("Creacion de personaje");

        System.out.println("Ingrese si es Héroe/Villano: ");
        String tipo = UserInterface.scanner.nextLine();

        System.out.println("Ingrese el nombre real:");
        String nombreReal = UserInterface.scanner.nextLine();

        System.out.println("Ingrese el nombre del personaje:");
        String nombrePersonaje = UserInterface.scanner.nextLine();

        try {
            System.out.println("Ingrese la Velocidad:");
            String velocidadString = UserInterface.scanner.nextLine();
            int velocidad = Integer.parseInt(velocidadString);

            System.out.println("Ingrese la Fuerza:");
            String fuerzaString = UserInterface.scanner.nextLine();
            int fuerza = Integer.parseInt(fuerzaString);

            System.out.println("Ingrese la Resistencia:");
            String resistenciaString = UserInterface.scanner.nextLine();
            int resistencia = Integer.parseInt(resistenciaString);

            System.out.println("Ingrese la Destreza:");
            String destrezaString = UserInterface.scanner.nextLine();
            int destreza = Integer.parseInt(destrezaString);

            switch (tipo) {
                case "Héroe":
                case "Heroe":
                    Main.listaPersonajes.put(nombrePersonaje,
                            new Heroe(nombreReal, nombrePersonaje, fuerza, resistencia, velocidad, destreza));
                    break;
                case "Villano":
                    Main.listaPersonajes.put(nombrePersonaje,
                            new Villano(nombreReal, nombrePersonaje, fuerza, resistencia, velocidad, destreza));
                    break;
                default:
                    System.out.println("Debe ingresar Heroe/Villano");
                    UserInterface.crearPersonaje();
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un numero para la velocidad, fuerza, resistencia y destreza");
            UserInterface.crearPersonaje();
        }
        System.out.println("El personaje se creo con exito");
        UserInterface.esperarConsola();
    }

    private static void mostrarMainPersonajes() {
        UserInterface.clearScreen();
        for (Personaje p : Main.listaPersonajes.values()) {
            System.out.println(p.toString());
        }
        UserInterface.esperarConsola();
    }

    private static void guardarPersonajeArchivo() {
        UserInterface.clearScreen();
        System.out.println("Ingrese el nombre del archivo de salida: ");
        String ubicacionSalida = UserInterface.scanner.nextLine();
        try {
            FilePersonaje.guardarPersonajes(ubicacionSalida + ".in");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: ");
            e.printStackTrace();
        }
        System.out.println("El archivo de personaje se guardo con exito");
        UserInterface.esperarConsola();
    }

    private static void cargarLigasArchivo() {
        UserInterface.clearScreen();
        System.out.println("Ingrese la ubicacion: ");
        String ubicacionEntrada = UserInterface.scanner.nextLine();
        try {
            FileLiga.cargarLigas(ubicacionEntrada);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no pudo ser encontrado");
            UserInterface.esperarConsola();
            UserInterface.administracionDeLigas();
        }
        UserInterface.esperarConsola();
    }

    private static void crearLiga() {
        UserInterface.clearScreen();
        Liga nuevaLiga = null;

        System.out.println("Ingresar el nombre de la liga:");
        String nombre = UserInterface.scanner.nextLine();

        System.out.println("Ingresar Heroe|Villano:");
        String tipo = UserInterface.scanner.nextLine();

        if (tipo.equals("Villano")) {
            nuevaLiga = new LigaVillano(nombre);
        } else if (tipo.equals("Heroe") || tipo.equals("Héroe")) {
            nuevaLiga = new LigaHeroe(nombre);
        } else {
            System.out.println("Debe ingresar Heroe o Villano");
            UserInterface.esperarConsola();
            UserInterface.administracionDeLigas();
        }

        System.out.println("Cuantos miembros tiene la liga");
        String numeroMiembrosString = UserInterface.scanner.nextLine();

        try {
            int numeroMiembros = Integer.parseInt(numeroMiembrosString.trim());
            if (numeroMiembros > 0) {
                for (int i = 0; i < numeroMiembros; i++) {
                    System.out.println(String.format("Ingrese el miembro %d:", i + 1));
                    String miembro = UserInterface.scanner.nextLine();
                    Personaje p = Main.listaPersonajes.get(miembro);
                    if (p != null) {
                        nuevaLiga.agregarCompetidor(p);
                    } else {
                        Liga l = Main.listaLigas.get(miembro);
                        if (l != null) {
                            nuevaLiga.agregarCompetidor(l);
                        } else {
                            System.out.println(String.format("No se encontro a %s", miembro));
                        }
                    }
                }
                if (!nuevaLiga.ligaVacia()) {
                    Main.listaLigas.put(nombre, nuevaLiga);
                }

            } else
                throw new Exception();
        } catch (Exception e) {
            System.out.println("Debe ingresar un numero de miembros mayor a 0");
            UserInterface.crearLiga();
        }
        System.out.println("La liga se creo con exito");
        UserInterface.esperarConsola();

    }

    private static void mostrarMainLigas() {
        UserInterface.clearScreen();
        for (Liga l : Main.listaLigas.values()) {
            System.out.println(l);
        }
        UserInterface.esperarConsola();
    }

    private static void guardarLigasArchivo() {
        UserInterface.clearScreen();
        System.out.println("Ingrese el nombre del archivo de salida: ");
        String ubicacionSalida = UserInterface.scanner.nextLine();
        try {
            FileLiga.guardarLigas(ubicacionSalida + ".in");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: ");
            e.printStackTrace();
        }
        System.out.println("El archivo de ligas se guardo con exito");
        UserInterface.esperarConsola();
    }

}