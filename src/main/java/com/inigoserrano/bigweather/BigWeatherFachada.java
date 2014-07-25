package com.inigoserrano.bigweather;

public class BigWeatherFachada {

	public void cargarAlmacenesDatos(final String fichero) {

	}

	public AlmacenDatos crearAlmacenDatos(final String nombreAlmacen) {
		return new AlmacenDatos(nombreAlmacen);
	}
}
