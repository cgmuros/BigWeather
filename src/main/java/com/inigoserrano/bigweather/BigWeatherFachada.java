package com.inigoserrano.bigweather;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.infinispan.distexec.mapreduce.MapReduceTask;

import com.inigoserrano.bigweather.util.CargarDatos;
import com.inigoserrano.bigweather.util.MapWeather;
import com.inigoserrano.bigweather.util.MostrarDatos;
import com.inigoserrano.bigweather.util.ReducerWeather;

public class BigWeatherFachada {

	private Datos datos;

	public BigWeatherFachada cargarDatos(final String nombreFichero, final String... nombreCampos)
			throws FileNotFoundException, IOException {
		CargarDatos cargarDatos = new CargarDatos();
		this.datos = cargarDatos.cargarDatos(nombreFichero, nombreCampos);
		return this;
	}

	public BigWeatherFachada mostrarDatos() {
		MostrarDatos mostrarDatos = new MostrarDatos();
		mostrarDatos.mostrarDatos(this.datos);
		return this;
	}

	public BigWeatherFachada mapReducer() {
		MapReduceTask<String, Map<String, String>, String, String> t = new MapReduceTask<String, Map<String, String>, String, String>(
				this.datos.getDatos());

		t.mappedWith(new MapWeather()).reducedWith(new ReducerWeather());
		Map<String, String> wordCountMap = t.execute();
		System.out.println(wordCountMap);
		return this;
	}

}
