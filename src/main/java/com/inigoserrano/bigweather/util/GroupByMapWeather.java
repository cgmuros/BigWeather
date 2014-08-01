package com.inigoserrano.bigweather.util;

import java.util.Map;

import org.infinispan.distexec.mapreduce.Collector;
import org.infinispan.distexec.mapreduce.Mapper;

public class GroupByMapWeather implements Mapper<String, Map<String, String>, String, String> {

	private final String sourceColumn;
	private final String functionColumn;

	public GroupByMapWeather(final String sourceColumn, final String functionColumn) {
		super();
		this.sourceColumn = sourceColumn;
		this.functionColumn = functionColumn;
	}

	@Override
	public void map(final String key, final Map<String, String> datos, final Collector<String, String> colector) {
		String fechaHora = datos.get(this.sourceColumn);
		colector.emit(fechaHora, datos.get(this.functionColumn));
	}

}
