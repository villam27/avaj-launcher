package com.avaj.simulator;

import com.avaj.logger.Logger;

public class Simulator {
	public static void main(String args[]) {
		FileReader parser;
		Data data = null;

		if (args.length != 1) {
			System.err.println("Error: please enter one argument");
			System.exit(1);
		}
		System.out.println("Start avaj launcher");
		Logger.create("simulation.txt");

		parser = new FileReader(args[0]);
		try {
			data = parser.getData();
		} catch(Exception e) {
			System.err.println(e);
			System.exit(1);
		}
		for (int i = 0; i < data.getNbrOfRestart(); i++) {
			data.getTower().changeWeather();
		}
	}
}