package com.avaj.simulator;

import com.avaj.Tower.WeatherTower;
import com.avaj.flyable.Flyable;

class Data {
	private int nbrOfRestart = 1;
	private WeatherTower tower = new WeatherTower();

	public Data() {}

	public int getNbrOfRestart() {
		return nbrOfRestart;
	}

	public void setNbrOfRestart(int p_restart) {
		nbrOfRestart = p_restart;
	}

	public WeatherTower getTower() {
		return tower;
	}

	public void addFlyable(Flyable p_flyable) {
		tower.register(p_flyable);
	}

	public void remFlyable(Flyable p_flyable) {
		tower.unregister(p_flyable);
	}
}
