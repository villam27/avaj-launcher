package com.avaj.simulator;

import java.io.File;
import java.util.Scanner;

import com.avaj.coordinates.Coordinates;
import com.avaj.exceptions.NotAPositiveInteger;
import com.avaj.exceptions.ParsingException;
import com.avaj.exceptions.TypeNotFoundException;
import com.avaj.flyable.Aircraft;
import com.avaj.flyable.AircraftFactory;

//	Todo: Put throws in each class and not directly handle errors in the Parser class
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
		int lineCount = 1;
		Data data = new Data();

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			if (lineCount == 1) {
				try {
					int value = readNbrOfRestart(line);
					data.setNbrOfRestart(value);
				} catch (Exception e) {
					System.err.println(e);
					System.exit(1);
				}
			} else {
				try {
					data.addFlyable(readAircraftData(line, lineCount));
				} catch(ParsingException e) {
					System.err.println(e);
					System.exit(1);
				}
			}
			lineCount++;
		}
		return data;
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
		//	Move it
		if (value <= 0)
			throw new NotAPositiveInteger(p_line, 1, file.getName());
		return value;
	}

	private Aircraft readAircraftData(String p_line, int p_lineCount)
	throws ParsingException {
		String[] token = p_line.split(" ");
		Aircraft aircraft = null;

		if (token.length != 5) {
			throw new ParsingException(p_line, p_lineCount, file.getName());
		}
		try {
			aircraft = (Aircraft)AircraftFactory.newAircraft(token[0], token[1],
															new Coordinates(
																Integer.parseInt(token[2]),
																Integer.parseInt(token[3]),
																Integer.parseInt(token[4])));
		} catch(TypeNotFoundException e) {
			System.err.println(e + " in " + file.getName() + ":" + p_lineCount);
			System.exit(1);
		} catch(NumberFormatException e) {
			System.err.println(e + " in " + file.getName() + ":" + p_lineCount);
			System.exit(1);
		}
		return aircraft;
	}

	public void dumpFile() {
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			System.out.println(line);
		}
	}
}
