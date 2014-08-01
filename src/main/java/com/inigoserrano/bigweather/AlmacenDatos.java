package com.inigoserrano.bigweather;

import java.io.File;
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
import com.inigoserrano.bigweather.util.AddColumMapWeather;
import com.inigoserrano.bigweather.util.GroupByMapWeather;
import com.inigoserrano.bigweather.util.MostrarDatos;
import com.inigoserrano.bigweather.util.AddColumReducerWeather;
import com.inigoserrano.bigweather.util.GroupByReducerWeather;

public class AlmacenDatos {

	private static final DefaultCacheManager DEFAULT_CACHE_MANAGER = new DefaultCacheManager();

	private final Cache<String, Map<String, String>> datos;

	private List<String> nombreCampos;

	private final File fichero;

	public AlmacenDatos(final String nombreAlmacen, final File fichero) {
		this.fichero = fichero;
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

	public AlmacenDatos seleccionar(final String unCampo, final String... masCampos) {

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

		t.mappedWith(new GroupByMapWeather()).reducedWith(new GroupByReducerWeather());
		return t.execute();
	}

	public AlmacenDatos anadirColumna(final String newColumName, final String originalColumName,
			final String transformerName) {

		MapReduceTask<String, Map<String, String>, String, String> t = new MapReduceTask<String, Map<String, String>, String, String>(
				this.datos);
		t.mappedWith(new AddColumMapWeather(originalColumName, BigWeatherFachada.getTransformer(transformerName)))
				.reducedWith(new AddColumReducerWeather(this, newColumName));
		// No necesitamos el map para nada
		Map<String, String> map = t.execute();

		return this;
	}

}