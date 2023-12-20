package com.avaj.flyable;

import com.avaj.coordinates.Coordinates;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);

		switch (weather) {
			case "SUN":
				break;
			case "RAIN":
				break;
			case "FOG":
				break;
			case "SNOW":
				break;
			default:
				break;
		}
	}
}
