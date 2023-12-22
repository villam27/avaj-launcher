package com.avaj.simulator;

import com.avaj.logger.logger;

public class Simulator {
	public static void main(String args[]) {
		Parser parser;
		Data data = null;

		if (args.length != 1) {
			System.err.println("Error: please enter one argument");
			System.exit(1);
		}
		System.out.println("Start avaj launcher");
		logger.create("simulation.txt");

		parser = new Parser(args[0]);
		data = parser.parseFile();
		for (int i = 0; i < data.getNbrOfRestart(); i++) {
			data.getTower().changeWeather();
		}
	}
}