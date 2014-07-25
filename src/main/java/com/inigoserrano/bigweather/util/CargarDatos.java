package com.inigoserrano.bigweather.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.inigoserrano.bigweather.Datos;

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
	public Datos cargarDatos(final String nombreFichero, final String... nombreCampos) throws FileNotFoundException,
			IOException {
		this.nombreFichero = nombreFichero;
		Datos datos = new Datos();
		try (FileReader ficheroDatos = new FileReader(nombreFichero)) {

			BufferedReader reader = new BufferedReader(ficheroDatos);

			String linea = null;
			Scanner scanner = null;
			int index = 0;

			if (this.saltarPrimeraLinea) {
				reader.readLine();
			}
			while ((linea = reader.readLine()) != null) {
				HashMap<String, String> datosLinea = new HashMap<>();
				scanner = new Scanner(linea);
				scanner.useDelimiter("\t");
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index < nombreCampos.length) {
						datosLinea.put(nombreCampos[index], data);
					}
					index++;
				}
				index = 0;
				// Meto los datos en la hash, se asume que la key es la primera columna
				datos.addCaptura(datosLinea.get(nombreCampos[0]), datosLinea);
			}

		}
		return datos;
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
