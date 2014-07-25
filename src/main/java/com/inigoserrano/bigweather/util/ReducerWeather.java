package com.inigoserrano.bigweather.util;

import java.util.Iterator;

import org.infinispan.distexec.mapreduce.Reducer;

public class ReducerWeather implements Reducer<String, String> {

	@Override
	public String reduce(final String key, final Iterator<String> iter) {

		int maximo = 0;
		while (iter.hasNext()) {
			String string = iter.next();
			if (Integer.parseInt(string) > maximo) {
				maximo = Integer.parseInt(string);
			}
		}
		return Integer.toString(maximo);
	}

}
