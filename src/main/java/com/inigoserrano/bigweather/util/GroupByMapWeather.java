package com.inigoserrano.bigweather.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.infinispan.distexec.mapreduce.Collector;
import org.infinispan.distexec.mapreduce.Mapper;

public class GroupByMapWeather implements Mapper<String, Map<String, String>, String, String> {

	@Override
	public void map(final String key, final Map<String, String> datos, final Collector<String, String> colector) {
		String fechaHora = datos.get("Time");
		SimpleDateFormat sdfCompleto = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
		try {
			String fecha = sdfFecha.format(sdfCompleto.parse(fechaHora));
			colector.emit(fecha, datos.get("Outdoor Temperature(°C)"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
