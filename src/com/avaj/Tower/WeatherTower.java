package com.avaj.Tower;

import com.avaj.coordinates.Coordinates;
import com.avaj.flyable.*;
import com.avaj.logger.Logger;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getCurrentWeather(p_coordinates);
	}

	public void changeWeather() {
		conditionChanged();
	}

	public void registerMessage(Flyable p_flyable) {
		Aircraft aircraft = (Aircraft)p_flyable;
		Class<? extends Aircraft> classAicraft = aircraft.getClass();
		String type = "";

		if (classAicraft == JetPlane.class) {
			type = "JetPlane";
		} else if (classAicraft == Helicopter.class) {
			type = "Helicopter";
		} else if (classAicraft == Baloon.class) {
			type = "Baloon";
		}
		Logger.writeln("Tower says: " + type + "#" + aircraft.getName()
							+ "(" + aircraft.getId() + ") registered from weather tower.");	
	}

	public void unregisterMessage(Flyable p_flyable) {
		Aircraft aircraft = (Aircraft)p_flyable;
		Class<? extends Aircraft> classAicraft = aircraft.getClass();
		String type = "";

		if (classAicraft == JetPlane.class) {
			type = "JetPlane";
		} else if (classAicraft == Helicopter.class) {
			type = "Helicopter";
		} else if (classAicraft == Baloon.class) {
			type = "Baloon";
		}
		Logger.writeln("Tower says: " + type + "#" + aircraft.getName()
							+ "(" + aircraft.getId() + ") unregistered from weather tower.");
	}
}
