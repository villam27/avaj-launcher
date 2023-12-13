package com.avaj.simulator;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.avaj.exceptions.NotAPositiveInteger;
import com.avaj.exceptions.TypeNotFoundException;
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

	public Data parseFile() {
		boolean first_line = true;
		Data data;

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			if (first_line) {
				try {
					int value = readNbrOfRestart(line);
					data = new Data(value);
				} catch (Exception e) {
					System.err.println(e);
					System.exit(1);
				}
				first_line = false;
			}
		}
		return new Data(5);
	}

	private int readNbrOfRestart(String p_line)
	throws NotAPositiveInteger {
		int value = 0;
		try {
			value = Integer.valueOf(p_line);
		} catch(NumberFormatException e) {
			System.err.println(e + " in " + file.getName() + ":" + 1);
			System.exit(1);
		}
		if (value <= 0)
			throw new NotAPositiveInteger(p_line, 1, file.getName());
		return value;
	}

	public void dumpFile() {
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			System.out.println(line);
		}
	}
}
