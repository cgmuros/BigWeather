package com.inigoserrano.bigweather.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datos implements Serializable {
	
	private String id;
	private Date fechaHora;
	private int intervalo;
	private String humedadInterior;
	private String temperaturaInterior;
	private String humedadExterior;
	private String temperaturaExterior;
	private String presion;
	private String wind;
	private String gust;
	private String direction;
	private String relativePressure;
	private String dewpoint;
	private String windchill;
	private String hourRainfall;
	private String a24hourRainfall;
	private String weekRainfall;
	private String monthRainfall;
	private String totalRainfall;
	private String windLevel;
	private String gustLevel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public void setFechaHora(String fechaHora) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		this.fechaHora = sdf.parse(fechaHora);
	}
	public int getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	public void setIntervalo(String intervalo) {
		this.intervalo = Integer.parseInt(intervalo);
	}
	public String getHumedadInterior() {
		return humedadInterior;
	}
	public void setHumedadInterior(String humedadInterior) {
		this.humedadInterior = humedadInterior;
	}
	public String getTemperaturaInterior() {
		return temperaturaInterior;
	}
	public void setTemperaturaInterior(String temperaturaInterior) {
		this.temperaturaInterior = temperaturaInterior;
	}
	public String getHumedadExterior() {
		return humedadExterior;
	}
	public void setHumedadExterior(String humedadExterior) {
		this.humedadExterior = humedadExterior;
	}
	public String getTemperaturaExterior() {
		return temperaturaExterior;
	}
	public void setTemperaturaExterior(String temperaturaExterior) {
		this.temperaturaExterior = temperaturaExterior;
	}
	public String getPresion() {
		return presion;
	}
	public void setPresion(String presion) {
		this.presion = presion;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getGust() {
		return gust;
	}
	public void setGust(String gust) {
		this.gust = gust;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getRelativePressure() {
		return relativePressure;
	}
	public void setRelativePressure(String relativePressure) {
		this.relativePressure = relativePressure;
	}
	public String getDewpoint() {
		return dewpoint;
	}
	public void setDewpoint(String dewpoint) {
		this.dewpoint = dewpoint;
	}
	public String getWindchill() {
		return windchill;
	}
	public void setWindchill(String windchill) {
		this.windchill = windchill;
	}
	public String getHourRainfall() {
		return hourRainfall;
	}
	public void setHourRainfall(String hourRainfall) {
		this.hourRainfall = hourRainfall;
	}
	public String getA24hourRainfall() {
		return a24hourRainfall;
	}
	public void setA24hourRainfall(String a24hourRainfall) {
		this.a24hourRainfall = a24hourRainfall;
	}
	public String getWeekRainfall() {
		return weekRainfall;
	}
	public void setWeekRainfall(String weekRainfall) {
		this.weekRainfall = weekRainfall;
	}
	public String getMonthRainfall() {
		return monthRainfall;
	}
	public void setMonthRainfall(String monthRainfall) {
		this.monthRainfall = monthRainfall;
	}
	public String getTotalRainfall() {
		return totalRainfall;
	}
	public void setTotalRainfall(String totalRainfall) {
		this.totalRainfall = totalRainfall;
	}
	public String getWindLevel() {
		return windLevel;
	}
	public void setWindLevel(String windLevel) {
		this.windLevel = windLevel;
	}
	public String getGustLevel() {
		return gustLevel;
	}
	public void setGustLevel(String gustLevel) {
		this.gustLevel = gustLevel;
	}
	@Override
	public String toString() {
		return "Datos [id=" + id + ", fechaHora=" + fechaHora + ", intervalo="
				+ intervalo + ", humedadInterior=" + humedadInterior
				+ ", temperaturaInterior=" + temperaturaInterior
				+ ", humedadExterior=" + humedadExterior
				+ ", temperaturaExterior=" + temperaturaExterior + ", presion="
				+ presion + ", wind=" + wind + ", gust=" + gust
				+ ", direction=" + direction + ", relativePressure="
				+ relativePressure + ", dewpoint=" + dewpoint + ", windchill="
				+ windchill + ", hourRainfall=" + hourRainfall
				+ ", a24hourRainfall=" + a24hourRainfall + ", weekRainfall="
				+ weekRainfall + ", monthRainfall=" + monthRainfall
				+ ", totalRainfall=" + totalRainfall + ", windLevel="
				+ windLevel + ", gustLevel=" + gustLevel + "]";
	}
	

}
