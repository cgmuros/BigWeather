package com.inigoserrano.bigweather.util;

import com.inigoserrano.bigweather.AlmacenDatos;

public class MostrarDatos {

	public void mostrarDatos(final AlmacenDatos datos) {
		for (String unRegistro : datos.keySet()) {
			System.out.print(unRegistro);
			System.out.print(" = ");
			System.out.println(datos.get(unRegistro));
		}
	}

}
