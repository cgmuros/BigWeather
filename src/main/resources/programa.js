function programa(){
	bigWeather.cargarAlmacenesDatos("C:\\Users\\Iñigo\\workspacejboss\\BigWeather\\src\\main\\resources\\EasyWeather.xml");
	bigWeather.registerTransformer("transformadorFecha","com.inigoserrano.bigweather.transformer.TransformerToDate","dd-MM-yyyy hh:mm","dd-MM-yyyy");
	bigWeather.registerTransformer("transformadorHora","com.inigoserrano.bigweather.transformer.TransformerToDate","dd-MM-yyyy hh:mm","hh:mm");
	
	var fichero2014 = bigWeather.crearAlmacenDatos("fichero2014");
	fichero2014.definirKey("No");
	fichero2014.definirDatos("No","Time", "Interval(mi)","Indoor Humidity(%)","Indoor Temperature(°C)","Outdoor Humidity(%)","Outdoor Temperature(°C)","Absolute Pressure(Hpa)","Wind(km/h)","Gust(km/h)","Direction","Relative Pressure(Hpa)","Dewpoint(°C)","Windchill(°C)","Hour Rainfall(mm)","24 hour Rainfall(mm)","Week Rainfall(mm)","Month Rainfall(mm)","Total Rainfall(mm)","Wind Level(bft)","Gust Level(bft)");
	fichero2014.cargarDatos("C:\\Users\\Iñigo\\workspacejboss\\BigWeather\\src\\main\\resources\\EasyWeather.txt");
	fichero2014.seleccionar("Time","Outdoor Temperature(°C)");
	fichero2014.anadirColumna("dia","Time","transformadorFecha");
	fichero2014.anadirColumna("hora","Time","transformadorHora");
	//fichero2014.filtrar("Time").mayorIgualQue("01-01-2013 00:00").menorIgualQue("31-12-2013 24:00");
	fichero2014.mostrar();
	
	var maximosDiarios = bigWeather.crearAlmacenDatos("maximosDiarios");
	maximosDiarios.definirKey("dia");
	maximosDiarios.definirDatos("dia","temperaturaMaxima");
	maximosDiarios.cargarDatos(fichero2014.groupBy("dia","max","Outdoor Temperature(°C)"));
	maximosDiarios.mostrar();
	
	var minimosDiarios = bigWeather.crearAlmacenDatos("minimosDiarios");
	minimosDiarios.definirKey("dia");
	minimosDiarios.definirDatos("dia","temperaturaMinima");
	minimosDiarios.cargarDatos(fichero2014.groupBy("dia","min","Outdoor Temperature(°C)"));
	minimosDiarios.mostrar();
}


