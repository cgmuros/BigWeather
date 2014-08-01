package com.inigoserrano.bigweather.groupByFuntion;

import java.util.Collection;
import java.util.Iterator;

public class MaxGroupByFunctionImpl implements GroupByFunction {

	@Override
	public Object function(final Collection<Object> colection) {
		return this.function(colection.iterator());
	}

	@Override
	public Object function(final Iterator<Object> iterator) {
		float maximo = 0;
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			// string = string.replace('.', ',');
			if (Float.parseFloat(string) > maximo) {
				maximo = Float.parseFloat(string);
			}
		}
		return Float.toString(maximo);
	}

}
