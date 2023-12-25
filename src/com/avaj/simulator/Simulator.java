package com.avaj.simulator;

import com.avaj.logger.Logger;

public class Simulator {
	public static void main(String args[]) {
		Data data = null;
		FileReader reader;

		if (args.length != 1) {
			System.err.println("Error: please enter one argument");
			System.exit(1);
		}
		Logger.create("simulation.txt");
		reader = new FileReader(args[0]);
		try {
			data = reader.getData();
		} catch(Exception e) {
			Simulator.exit(1, e);
		}
		for (int i = 0; i < data.getNbrOfRestart(); i++) {
			data.getTower().changeWeather();
		}
	}

	public static void exit(int status, Exception e) {
		System.err.println(e);
		System.exit(status);
	}
}