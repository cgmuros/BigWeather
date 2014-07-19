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

/**
 * Clase para la carga de los datos
 * 
 * @author Iñigo Serrano <contacto@inigoserrano.com>
 * 
 */
public class CargarDatos {

	/**
	 * Nombre del fichero de donde cargar los datos
	 */
	private String nombreFichero;

	/**
	 * Si hay que saltarse la primera línea
	 */
	private boolean saltarPrimeraLinea = true;

	/**
	 * Carga el fichero con los datos
	 * 
	 * @param nombreFichero
	 *            Nombre del fichero a cargar
	 * @param nombreCampos
	 *            Nombre de cada campo
	 * @return Lista con un map por cada línea
	 * @throws IOException
	 *             Si error al leer el fichero
	 * @throws FileNotFoundException
	 *             Si no encuentra el fichero
	 */
	public List<Map<String, String>> cargarDatos(final String nombreFichero, final String... nombreCampos)
			throws FileNotFoundException, IOException {
		this.nombreFichero = nombreFichero;
		List<Map<String, String>> listaDatos = new ArrayList<Map<String, String>>();
		try (FileReader ficheroDatos = new FileReader(nombreFichero)) {

			BufferedReader reader = new BufferedReader(ficheroDatos);

			String linea = null;
			Scanner scanner = null;
			int index = 0;

			if (this.saltarPrimeraLinea) {
				reader.readLine();
			}
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

		}
		return listaDatos;

	}

	public String getNombreFichero() {
		return this.nombreFichero;
	}

	public void setNombreFichero(final String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	public boolean isSaltarPrimeraLinea() {
		return this.saltarPrimeraLinea;
	}

	public void setSaltarPrimeraLinea(final boolean saltarPrimeraLinea) {
		this.saltarPrimeraLinea = saltarPrimeraLinea;
	}

}
