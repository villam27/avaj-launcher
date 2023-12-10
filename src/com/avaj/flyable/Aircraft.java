package com.avaj.flyable;

public class Aircraft extends Flyable {
	//	Variables
	protected long id;
	protected String name;
	//	Protected Coordinate

	protected Aircraft(long p_id, String p_name /*, Coordinates p_coordinate */) {
		id = p_id;
		name = p_name;
		//	Coordinates
	}

	public void updateConditions() {}
}
