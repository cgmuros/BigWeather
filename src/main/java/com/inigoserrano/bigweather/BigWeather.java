package com.inigoserrano.bigweather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class BigWeather {

	public static void main(final String[] args) {

		try {
			File fichero = new File(args[0]);
			BigWeatherFachada bigWeather = new BigWeatherFachada(fichero);

			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");

			engine.put("bigWeather", bigWeather);

			engine.eval(new FileReader(fichero));

			Invocable inv = (Invocable) engine;
			Date inicio = new Date();
			inv.invokeFunction("programa");
			Date fin = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			System.out.println("Inicio: " + sdf.format(inicio));
			System.out.println("Fin:    " + sdf.format(fin));

		} catch (ScriptException | NoSuchMethodException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
