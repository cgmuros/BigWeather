package com.inigoserrano.bigweather.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.inigoserrano.bigweather.AlmacenDatos;

/**
 * Clase para la carga de los datos
 * 
 * @author Iñigo Serrano <contacto@inigoserrano.com>
 * 
 */
public class CargarDatos {

	public CargarDatos(final AlmacenDatos almacenDatos) {
		super();
		this.cache = almacenDatos;
	}

	private final AlmacenDatos cache;

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
	public void cargarDatos(final String nombreFichero, final List<String> nombreCampos) throws FileNotFoundException,
			IOException {
		this.nombreFichero = nombreFichero;
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
					if (index < nombreCampos.size()) {
						datosLinea.put(nombreCampos.get(index), data);
					}
					index++;
				}
				index = 0;
				// Meto los datos en la hash, se asume que la key es la primera columna
				this.cache.addCaptura(datosLinea.get(nombreCampos.get(0)), datosLinea);
			}

		}
	}

	public void cargarDatos(final Map<String, String> nuevosDatos, final List<String> nombreCampos)
			throws FileNotFoundException, IOException {

		for (String unaKey : nuevosDatos.keySet()) {
			HashMap<String, String> datosLinea = new HashMap<>();
			datosLinea.put(nombreCampos.get(0), unaKey);
			datosLinea.put(nombreCampos.get(1), nuevosDatos.get(unaKey));
			this.cache.addCaptura(datosLinea.get(nombreCampos.get(0)), datosLinea);
		}

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
