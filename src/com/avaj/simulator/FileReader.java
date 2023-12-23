package com.avaj.simulator;

import java.io.File;
import java.util.Scanner;

import com.avaj.coordinates.Coordinates;
import com.avaj.exceptions.NoDataFound;
import com.avaj.exceptions.NotAPositiveInteger;
import com.avaj.exceptions.NotAValidHeight;
import com.avaj.exceptions.ParsingException;
import com.avaj.exceptions.TypeNotFoundException;
import com.avaj.flyable.Aircraft;
import com.avaj.flyable.AircraftFactory;

//	Todo: Put throws in each class and not directly handle errors in the Parser class
public class FileReader {
	private File file;
	private Scanner reader;

	FileReader(String p_file) {
		try {
			file = new File(p_file);
			reader = new Scanner(file);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public Data getData() 
	throws NotAPositiveInteger, ParsingException, NoDataFound, NotAValidHeight {
		int lineCount = 1;
		Data data = new Data();

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			if (lineCount == 1) {
				data.setNbrOfRestart(readNbrOfRestart(line));
			} else {
				data.addFlyable(readAircraftData(line, lineCount));
			}
			lineCount++;
		}
		if (lineCount <= 2)
			throw new NoDataFound(file.getName());
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
		if (value <= 0)
			throw new NotAPositiveInteger(p_line, 1, file.getName());
		return value;
	}

	private Aircraft readAircraftData(String p_line, int p_lineCount)
	throws ParsingException, NotAPositiveInteger, NotAValidHeight {
		String[] token = p_line.split(" ");
		Aircraft aircraft = null;
		Coordinates coordinates = null;

		if (token.length != 5) {
			throw new ParsingException(p_line, p_lineCount, file.getName());
		}
		try {
			coordinates = new Coordinates(Integer.parseInt(token[2]),
										Integer.parseInt(token[3]),
										Integer.parseInt(token[4]));
			aircraft = (Aircraft)AircraftFactory.newAircraft(token[0], token[1], coordinates);
		} catch(TypeNotFoundException e) {
			System.err.println(e + " in " + file.getName() + ":" + p_lineCount);
			System.exit(1);
		} catch(NumberFormatException e) {
			System.err.println(e + " in " + file.getName() + ":" + p_lineCount);
			System.exit(1);
		}
		if (coordinates.getLatitude() < 0 || coordinates.getLongitude() < 0) {
			throw new NotAPositiveInteger(p_line, p_lineCount, file.getName());
		}
		if (coordinates.getHeight() < 0 || coordinates.getHeight() > 100) {
			throw new NotAValidHeight(p_line, p_lineCount, file.getName());
		}
		return aircraft;
	}
}
