package com.inigoserrano.bigweather.util;

import java.util.Iterator;

import org.infinispan.distexec.mapreduce.Reducer;

public class GroupByReducerWeather implements Reducer<String, String> {

	@Override
	public String reduce(final String key, final Iterator<String> iter) {

		float maximo = 0;
		while (iter.hasNext()) {
			String string = iter.next();
			// string = string.replace('.', ',');
			if (Float.parseFloat(string) > maximo) {
				maximo = Float.parseFloat(string);
			}
		}
		return Float.toString(maximo);
	}

}
