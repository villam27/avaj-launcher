package com.avaj.flyable;

import com.avaj.Tower.WeatherTower;

public abstract class Flyable {
	protected WeatherTower weatherTower;
	
	public abstract void updateConditions();
	public void registerTower(WeatherTower p_Tower) {
		weatherTower = p_Tower;
	}
}