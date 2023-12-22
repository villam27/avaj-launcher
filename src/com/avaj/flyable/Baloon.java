package com.avaj.flyable;

import com.avaj.coordinates.Coordinates;
import com.avaj.logger.logger;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		int height = coordinates.getHeight();
		int lat = coordinates.getLatitude();
		int lon = coordinates.getLongitude();
		String message = "";

		switch (weather) {
			case "SUN":
				lon += 2;
				height += 4;
				message = "Oh the sun is burning my eyes.";
				break;
			case "RAIN":
				height -= 5;
				message = "I'm all wet.";
				break;
			case "FOG":
				height -= 3;
				message = "Where are we?";
				break;
			case "SNOW":
				height -= 15;
				message = "Oh no! we gonna crash!";
				break;
			default:
				break;
		}
		if (height > 100)
			height = 100;
		logger.write("Baloon#" + name + "(" + id + "): " + message);
		coordinates = new Coordinates(lon, lat, height);
		if (height <= 0) {
			logger.write("Baloon#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
			unregisterTower();
		}
	}
}
