package com.inigoserrano.bigweather.util;

import com.inigoserrano.bigweather.Datos;

public class MostrarDatos {

	public void mostrarDatos(final Datos datos) {
		for (String unRegistro : datos.keySet()) {
			System.out.print(unRegistro);
			System.out.print(" = ");
			System.out.println(datos.get(unRegistro));
		}
	}

}
