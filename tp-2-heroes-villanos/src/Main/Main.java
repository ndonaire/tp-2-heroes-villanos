package Main;

import java.util.HashMap;
import java.util.LinkedHashMap;

import Composite.Liga;
import Composite.Personaje;
import UserInterface.UserInterface;

public class Main {
	public static HashMap<String, Personaje> listaPersonajes = new HashMap<String, Personaje>();
	public static LinkedHashMap<String, Liga> listaLigas = new LinkedHashMap<String, Liga>();

	public static void main(String[] args) {
		UserInterface.menuPrincipal();
	}
}
