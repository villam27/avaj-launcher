package com.avaj.flyable;

import com.avaj.coordinates.Coordinates;

public class Aircraft extends Flyable {
	//	Variables
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinate;
	}

	public void updateConditions() {}
}
