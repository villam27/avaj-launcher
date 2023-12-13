package com.avaj.simulator;

public class Simulator {
	private static Parser parser;

	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("Error: please enter one argument");
			System.exit(1);
		}
		parser = new Parser(args[0]);
		System.out.println("Start avaj launcher");
		parser.parseFile();
	}
}