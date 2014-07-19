package com.inigoserrano.bigweather;

import java.util.List;
import java.util.Map;

import com.inigoserrano.bigweather.util.CargarDatos;

public class BigWeather {

	public static void main(final String[] args) {
		CargarDatos cargarDatos = new CargarDatos();
		List<Map<String, String>> datos = cargarDatos.cargarDatos(args[0], args);
		System.out.println(datos);
	}

}
