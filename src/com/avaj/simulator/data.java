package com.avaj.simulator;

import com.avaj.flyable.Flyable;

import java.util.ArrayList;
import java.util.List;

class Data {
	private int nbrOfRestart = 1;
	private List<Flyable> flyables = new ArrayList<Flyable>();

	public Data() {}

	public int getNbrOfRestart() {
		return nbrOfRestart;
	}

	public void setNbrOfRestart(int p_restart) {
		nbrOfRestart = p_restart;
	}

	public List<Flyable> getFlyables() {
		return flyables;
	}

	public void addFlyable(Flyable p_flyable) {
		flyables.add(p_flyable);
	}
}
