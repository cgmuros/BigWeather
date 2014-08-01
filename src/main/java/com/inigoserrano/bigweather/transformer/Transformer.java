package com.inigoserrano.bigweather.transformer;

public interface Transformer {

	public void configure(Object... arguments);

	public Object transform(final Object inputObject);

}
