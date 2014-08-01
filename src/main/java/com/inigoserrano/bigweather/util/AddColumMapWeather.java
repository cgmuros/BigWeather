package com.inigoserrano.bigweather.util;

import java.util.Map;

import org.infinispan.distexec.mapreduce.Collector;
import org.infinispan.distexec.mapreduce.Mapper;

import com.inigoserrano.bigweather.transformer.Transformer;

public class AddColumMapWeather implements Mapper<String, Map<String, String>, String, String> {

	private final Transformer transformer;
	private final String originalColumName;

	public AddColumMapWeather(final String originalColumName, final Transformer transformer) {
		super();
		this.transformer = transformer;
		this.originalColumName = originalColumName;
	}

	@Override
	public void map(final String key, final Map<String, String> datos, final Collector<String, String> colector) {
		String fechaHora = datos.get(this.originalColumName);
		colector.emit(key, (String) this.transformer.transform(fechaHora));
	}

}
