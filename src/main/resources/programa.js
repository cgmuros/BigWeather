function programa(){
	bigWeather.cargarAlmacenesDatos("C:\\Users\\Iñigo\\workspacejboss\\BigWeather\\src\\main\\resources\\EasyWeather.xml");
	var fichero2014 = bigWeather.crearAlmacenDatos("fichero2014");
	fichero2014.definirKey("No");
	fichero2014.definirDatos("No","Time", "Interval(mi)","Indoor Humidity(%)","Indoor Temperature(°C)","Outdoor Humidity(%)","Outdoor Temperature(°C)","Absolute Pressure(Hpa)","Wind(km/h)","Gust(km/h)","Direction","Relative Pressure(Hpa)","Dewpoint(°C)","Windchill(°C)","Hour Rainfall(mm)","24 hour Rainfall(mm)","Week Rainfall(mm)","Month Rainfall(mm)","Total Rainfall(mm)","Wind Level(bft)","Gust Level(bft)");
	fichero2014.cargarDatos("C:\\Users\\Iñigo\\workspacejboss\\BigWeather\\src\\main\\resources\\EasyWeather.txt");
	fichero2014.mostrar();
	
	var maximosDiarios = bigWeather.crearAlmacenDatos("maximosDiarios");
	maximosDiarios.definirKey("dia");
	maximosDiarios.definirDatos("dia","temperatura");
	maximosDiarios.cargarDatos(fichero2014.mapReduce("mapDiaTemperatura","reduceTemperaturaMaxima"));
	maximosDiarios.mostrar();
}

function mapDiaTemperatura(key, datos, recolector){
	
}

function reduceTemperaturaMaxima(key, valores){
	
}