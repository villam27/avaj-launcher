package com.avaj.simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.avaj.flyable.Flyable;

class Data {
	private int loop_nbr;
	private List<Flyable> flyables;

	public Data(int p_loop_nbr) {
		loop_nbr = p_loop_nbr;
	}

	public int getLoopNbr() {
		return loop_nbr;
	}

	public List<Flyable> getFlyables() {
		return flyables;
	}

	public void addFlyable(Flyable p_flyable) {
		flyables.add(p_flyable);
	}
}

public class Parser {
	private File file;
	private Scanner reader;

	Parser(String p_file) {
		try {
			file = new File(p_file);
			reader = new Scanner(file);	
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void dumpFile() {
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			System.out.println(line);
		}
	}
}
