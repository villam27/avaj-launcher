package com.avaj.flyable;

import com.avaj.coordinates.Coordinates;
import com.avaj.exceptions.TypeNotFoundException;

public class AircraftFactory {
	private static long next_id = 0;

	private AircraftFactory() {}
	
	public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	throws TypeNotFoundException {

		switch (p_type) {
			case "Baloon":
				return new Baloon(next_id++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(next_id++, p_name, p_coordinates);
			case "Helicopter":
				return new Helicopter(next_id++, p_name, p_coordinates);
			default:
				throw new TypeNotFoundException(p_type);
		}
	}
}
