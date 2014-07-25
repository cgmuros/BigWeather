package com.inigoserrano.bigweather;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.infinispan.Cache;
import org.infinispan.distexec.mapreduce.MapReduceTask;
import org.infinispan.manager.DefaultCacheManager;

import com.inigoserrano.bigweather.util.CargarDatos;
import com.inigoserrano.bigweather.util.MapWeather;
import com.inigoserrano.bigweather.util.MostrarDatos;
import com.inigoserrano.bigweather.util.ReducerWeather;

public class AlmacenDatos {

	private static final DefaultCacheManager DEFAULT_CACHE_MANAGER = new DefaultCacheManager();

	private final Cache<String, Map<String, String>> datos;

	private List<String> nombreCampos;

	public AlmacenDatos(final String nombreAlmacen) {
		this.datos = DEFAULT_CACHE_MANAGER.getCache(nombreAlmacen);
	}

	public void addCaptura(final String key, final Map<String, String> datos) {
		this.datos.put(key, datos);
	}

	public Map<String, String> get(final Object key) {
		return this.datos.get(key);
	}

	public Set<String> keySet() {
		return this.datos.keySet();
	}

	public Cache<String, Map<String, String>> getDatos() {
		return this.datos;
	}

	public AlmacenDatos definirKey(final String key, final String... masKeys) {
		return this;
	}

	public AlmacenDatos definirDatos(final String unDato, final String... masDatos) {
		this.nombreCampos = new ArrayList<String>(masDatos.length + 1);
		this.nombreCampos.add(unDato);
		this.nombreCampos.addAll(Arrays.asList(masDatos));
		return this;
	}

	public AlmacenDatos cargarDatos(final String nombreFichero) throws FileNotFoundException, IOException {
		CargarDatos cargarDatos = new CargarDatos(this);
		cargarDatos.cargarDatos(nombreFichero, this.nombreCampos);
		return this;
	}

	public AlmacenDatos cargarDatos(final Map<String, String> datos) throws FileNotFoundException, IOException {
		CargarDatos cargarDatos = new CargarDatos(this);
		cargarDatos.cargarDatos(datos, this.nombreCampos);
		return this;
	}

	public AlmacenDatos mostrar() {
		MostrarDatos mostrarDatos = new MostrarDatos();
		mostrarDatos.mostrarDatos(this);
		return this;
	}

	public Map<String, String> mapReduce(final String funcionMap, final String funcionReduce) {
		MapReduceTask<String, Map<String, String>, String, String> t = new MapReduceTask<String, Map<String, String>, String, String>(
				this.datos);

		t.mappedWith(new MapWeather()).reducedWith(new ReducerWeather());
		return t.execute();
	}

}