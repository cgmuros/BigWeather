package com.inigoserrano.bigweather.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CargarDatos {

	public List<Map<String, String>> cargarDatos(final String nombreFichero, final String... nombreCampos) {
		List<Map<String, String>> listaDatos = new ArrayList<Map<String, String>>();
		try (FileReader ficheroDatos = new FileReader(nombreFichero)) {

			BufferedReader reader = new BufferedReader(ficheroDatos);

			String linea = null;
			Scanner scanner = null;
			int index = 0;

			// La primera línea me la salto
			reader.readLine();
			while ((linea = reader.readLine()) != null) {
				HashMap<String, String> emp = new HashMap<>();
				scanner = new Scanner(linea);
				scanner.useDelimiter("\t");
				while (scanner.hasNext()) {
					String data = scanner.next();
					emp.put(nombreCampos[index], data);
					index++;
				}
				index = 0;
				listaDatos.add(emp);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaDatos;

	}

}
