package com.avaj.flyable;

import com.avaj.coordinates.Coordinates;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
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
				lon += 10;
				height += 2;
				message = "What a beautiful day!";
				break;
			case "RAIN":
				lon += 5;
				message = "I hate water!";
				break;
			case "FOG":
				lon += 1;
				message = "Can't see where im going!";
				break;
			case "SNOW":
				height -= 12;
				message = "Its so cold we are losing height!";
				break;
			default:
				break;
		}
		if (height > 100)
			height = 100;
		System.out.println("Helicopter#" + name + "(" + id + "): " + message);
		coordinates = new Coordinates(lon, lat, height);
		if (height <= 0) {
			System.out.println("Helicopter#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
			unregisterTower();
		}
	}
}
