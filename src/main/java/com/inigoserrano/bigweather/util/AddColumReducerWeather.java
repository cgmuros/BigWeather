package com.inigoserrano.bigweather.util;

import java.util.Iterator;
import java.util.Map;

import org.infinispan.distexec.mapreduce.Reducer;

import com.inigoserrano.bigweather.AlmacenDatos;

public class AddColumReducerWeather implements Reducer<String, String> {

	private final AlmacenDatos almacenDatos;
	private final String nombreParametro;

	public AddColumReducerWeather(final AlmacenDatos almacenDatos, final String nombreParametro) {
		super();
		this.almacenDatos = almacenDatos;
		this.nombreParametro = nombreParametro;
	}

	@Override
	public String reduce(final String key, final Iterator<String> iter) {
		String value = iter.next();
		Map<String, String> map = this.almacenDatos.getDatos().get(key);
		map.put(this.nombreParametro, value);
		this.almacenDatos.getDatos().replace(key, map);
		return value;
	}

}
