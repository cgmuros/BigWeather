package com.inigoserrano.bigweather;

import java.util.Map;
import java.util.Set;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

public class Datos {
	private final Cache<String, Map<String, String>> datos;

	public Datos() {
		this.datos = new DefaultCacheManager().getCache();
	}

	public void addCaptura(final String key, final Map<String, String> datos) {
		this.datos.put(key, datos);
	}

	public Map<String, String> get(final Object key) {
		return this.datos.get(key);
	}

	public Set<String> keySet() {
		return this.datos.keySet();
	}

	public Cache<String, Map<String, String>> getDatos() {
		return this.datos;
	}

}