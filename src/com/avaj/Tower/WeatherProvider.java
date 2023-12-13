package com.avaj.Tower;

import com.avaj.coordinates.Coordinates;

public class WeatherProvider {
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	private WeatherProvider() {}

	public static String getCurrentWeather(Coordinates p_coordinates) {
		int position = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();
		return weather[position % 4];
	}
}
