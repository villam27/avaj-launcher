package com.avaj.coordinates;

public class Coordinates {
	private int longitude;
	private int latitute;
	private int height;

	void Coordinate(int p_longiture, int p_latitute, int p_height) {
		longitude = p_longiture;
		latitute = p_latitute;
		height = p_height;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitute;
	}

	public int getHeight() {
		return height;
	}
}