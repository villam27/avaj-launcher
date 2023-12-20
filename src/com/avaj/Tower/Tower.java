package com.avaj.Tower;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.avaj.flyable.*;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();
	private List<Flyable> observersRemove = new ArrayList<>();

	public void register(Flyable p_flyable) {
		registerMessage(p_flyable);
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		unregisterMessage(p_flyable);
		observersRemove.add(p_flyable);
	}

	protected void conditionChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
		for (Flyable flyable : observersRemove) {
			observers.remove(flyable);
		}
		observersRemove.clear();
	}

	protected void registerMessage(Flyable p_flyable) {}
	protected void unregisterMessage(Flyable p_flyable) {}
}
