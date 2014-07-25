package com.inigoserrano.bigweather;

import java.io.IOException;

public class BigWeather {

	public static void main(final String[] args) {
		try {
			BigWeatherFachada bigWeather = new BigWeatherFachada();
			String[] clonado = new String[args.length - 1];
			for (int i = 1; i < args.length; i++) {
				clonado[i - 1] = args[i];
			}
			bigWeather.cargarDatos(args[0], clonado);
			bigWeather.mostrarDatos();
			bigWeather.mapReducer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
