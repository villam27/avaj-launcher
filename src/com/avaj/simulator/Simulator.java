package com.avaj.simulator;

public class Simulator {
	private static Parser parser = new Parser(".gitignore");

	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("Error: please enter one argument");
			System.exit(1);
		}
		System.out.println("Start avaj launcher");
		parser.dumpFile();
	}
}