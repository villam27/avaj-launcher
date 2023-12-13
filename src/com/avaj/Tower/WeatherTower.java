package com.avaj.Tower;

import com.avaj.coordinates.Coordinates;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getCurrentWeather(p_coordinates);
	}

	public void changeWeather() {
		conditionChanged();
	}
}
