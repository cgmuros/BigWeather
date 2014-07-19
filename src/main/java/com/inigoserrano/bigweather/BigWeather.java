package com.inigoserrano.bigweather;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.inigoserrano.bigweather.util.CargarDatos;

public class BigWeather {

	public static void main(final String[] args) {
		try {
			CargarDatos cargarDatos = new CargarDatos();
			List<Map<String, String>> datos = cargarDatos.cargarDatos(args[0], args);
			System.out.println(datos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
