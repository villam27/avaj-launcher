package com.avaj.flyable;

import com.avaj.coordinates.Coordinates;
import com.avaj.logger.Logger;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
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
				lat += 10;
				height += 2;
				message = "Enjoy the sunny days!";
				break;
			case "RAIN":
				lat += 5;
				message = "Ladies and gentlemen, we are approaching an area of turbulence and we may experience bumpy conditions.";
				break;
			case "FOG":
				lon += 1;
				message = "I CANT SEE ANYTHING HERE!";
				break;
			case "SNOW":
				height -= 7;
				message = "Freeeezing!!!";
				break;
			default:
				break;
		}
		if (height > 100)
			height = 100;
		Logger.writeln("JetPlane#" + name + "(" + id + "): " + message);
		coordinates = new Coordinates(lon, lat, height);
		if (height <= 0) {
			Logger.writeln("JetPlane#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
			unregisterTower();
		}
	}
}
