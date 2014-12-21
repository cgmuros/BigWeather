package com.inigoserrano.bigweather;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.inigoserrano.bigweather.groupByFuntion.GroupByFunction;
import com.inigoserrano.bigweather.groupByFuntion.MaxGroupByFunctionImpl;
import com.inigoserrano.bigweather.groupByFuntion.MinGroupByFunctionImpl;
import com.inigoserrano.bigweather.transformer.Transformer;

public class BigWeatherFachada {

	private final File fichero;
	private static final Map<String, Transformer> transformers = new HashMap<String, Transformer>();
	private static final Map<String, GroupByFunction> functions = new HashMap<String, GroupByFunction>();

	public BigWeatherFachada(final File fichero) {
		super();
		this.fichero = fichero;
		functions.put("max", new MaxGroupByFunctionImpl());
		functions.put("min", new MinGroupByFunctionImpl());

	}

	public void cargarAlmacenesDatos(final String fichero) {

	}

	public AlmacenDatos crearAlmacenDatos(final String nombreAlmacen) {
		return new AlmacenDatos(nombreAlmacen, this.fichero);
	}

	public void registerTransformer(final String transformerName, final String transformerImpl,
			final Object... arguments) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Transformer instance = (Transformer) Class.forName(transformerImpl).newInstance();
		instance.configure(arguments);
		BigWeatherFachada.transformers.put(transformerName, instance);
	}

	public static Transformer getTransformer(final String transformerName) {
		return transformers.get(transformerName);
	}

	public static GroupByFunction getFunction(final String functionName) {
		return functions.get(functionName);
	}

	public Filter defineFilter(final String columName) {
		return new Filter(columName);
	}
}
