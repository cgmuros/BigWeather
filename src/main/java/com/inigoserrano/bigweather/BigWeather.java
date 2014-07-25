package com.inigoserrano.bigweather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class BigWeather {

	public static void main(final String[] args) {

		try {
			BigWeatherFachada bigWeather = new BigWeatherFachada();

			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");

			engine.put("bigWeather", bigWeather);
			File fichero = new File(args[0]);
			engine.eval(new FileReader(fichero));

			Invocable inv = (Invocable) engine;
			inv.invokeFunction("programa");

		} catch (ScriptException | NoSuchMethodException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
