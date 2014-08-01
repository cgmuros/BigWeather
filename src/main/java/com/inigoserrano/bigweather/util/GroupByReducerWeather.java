package com.inigoserrano.bigweather.util;

import java.util.Iterator;

import org.infinispan.distexec.mapreduce.Reducer;

import com.inigoserrano.bigweather.groupByFuntion.GroupByFunction;

public class GroupByReducerWeather implements Reducer<String, String> {

	private final GroupByFunction function;

	public GroupByReducerWeather(final GroupByFunction function) {
		super();
		this.function = function;
	}

	@Override
	public String reduce(final String key, final Iterator<String> iter) {
		return (String) this.function.function((Iterator) iter);
	}

}
