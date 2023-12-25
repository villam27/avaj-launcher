package com.avaj.logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.avaj.simulator.Simulator;

public final class Logger {
	private static Path file;

	public static void create(String p_name) {
		file = Path.of(p_name);
		deleteIfExist();
		createFile();
	}

	public static void writeln(String p_line) {
		try {
			Files.write(file, (p_line + "\n").getBytes(), StandardOpenOption.APPEND);
		} catch(Exception e) {
			Simulator.exit(1, e);
		}
	}

	private static void deleteIfExist() {
		try {
			if (Files.exists(file)) {
				Files.delete(file);
			}
		} catch(Exception e) {
			Simulator.exit(1, e);
		}
	}

	private static void createFile() {
		try {	
			Files.createFile(file);
		} catch(Exception e) {
			Simulator.exit(1, e);
		}
	}
}
