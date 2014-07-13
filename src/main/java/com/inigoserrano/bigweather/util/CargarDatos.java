package com.inigoserrano.bigweather.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CargarDatos {

	public static void main(String[] args) {
		try (FileReader ficheroDatos = new FileReader("C:\\Users\\Iñigo\\workspacejboss\\BigWeather\\src\\main\\resources\\EasyWeather.txt")){
			
			BufferedReader reader = new BufferedReader(ficheroDatos);

			String linea = null;
			Scanner scanner = null;
			int index = 0;
			List<Datos> listaDatos = new ArrayList<Datos>();
			
			//La primera línea me la salto
			reader.readLine();			
			while ((linea = reader.readLine()) != null) {
				Datos emp = new Datos();
				scanner = new Scanner(linea);
				scanner.useDelimiter("\t");
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index == 0)
						emp.setId(data);
					else if (index == 1)
						emp.setFechaHora(data);
					else if (index == 2)
						emp.setIntervalo(data);
					else if (index == 3)
						emp.setHumedadInterior(data);
					index++;
				}
				index = 0;
				listaDatos.add(emp);
			}

			System.out.println(listaDatos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
