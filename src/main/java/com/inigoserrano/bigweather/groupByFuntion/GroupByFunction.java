package com.inigoserrano.bigweather.groupByFuntion;

import java.util.Collection;
import java.util.Iterator;

public interface GroupByFunction {

	Object function(Collection<Object> colection);

	Object function(Iterator<Object> iterator);

}
