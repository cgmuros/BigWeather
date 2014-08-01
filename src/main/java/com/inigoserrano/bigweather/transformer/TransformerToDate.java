package com.inigoserrano.bigweather.transformer;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransformerToDate implements Transformer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1910447656505387635L;

	private String formatoOrigen;
	private String formatoDestino;

	@Override
	public Object transform(final Object inputObject) {
		String fechaHora = (String) inputObject;
		SimpleDateFormat sdfCompleto = new SimpleDateFormat(this.formatoOrigen);
		SimpleDateFormat sdfFecha = new SimpleDateFormat(this.formatoDestino);
		try {
			String fecha = sdfFecha.format(sdfCompleto.parse(fechaHora));
			return fecha;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void configure(final Object... arguments) {
		this.formatoOrigen = (String) arguments[0];
		this.formatoDestino = (String) arguments[1];
	}

}
