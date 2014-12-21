package com.inigoserrano.bigweather;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Filter {

	private String columName;
	private final List<Object[]> conditions = new LinkedList<>();

	public Filter(final String columName) {
		super();
		this.columName = columName;
	}

	public boolean doFilter(final Map<String, String> data) {
		Object columValue = data.get(this.columName);
		for (Object[] oneCondition : this.conditions) {
			switch ((String) oneCondition[0]) {
			case ">":
				if (((Date) columValue).before((Date) oneCondition[1])) {
					return true;
				}
				break;

			default:
				break;
			}
		}
		return false;
	}

	public Filter greaterThan(final String value) {
		this.conditions.add(new Object[] { ">", value });
		return this;
	}

	public String getColumName() {
		return this.columName;
	}

	public void setColumName(final String columName) {
		this.columName = columName;
	}

}
