package com.avaj.Tower;

import java.util.ArrayList;
import java.util.List;
import com.avaj.flyable.*;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable p_flyable) {
		registerMessage(p_flyable);
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		unregisterMessage(p_flyable);
		observers.remove(p_flyable);
	}

	protected void conditionChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
	}

	protected void registerMessage(Flyable p_flyable) {}
	protected void unregisterMessage(Flyable p_flyable) {}
}
