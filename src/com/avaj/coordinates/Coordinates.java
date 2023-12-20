package com.avaj.coordinates;

public class Coordinates {
	private int longitude;
	private int latitute;
	private int height;

	public Coordinates(int p_longitude, int p_latitute, int p_height) {
		longitude = p_longitude;
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