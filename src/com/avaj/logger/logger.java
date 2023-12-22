package com.avaj.logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class Logger {
	private static Path file = Path.of("simulation.txt");

	public static void create(String p_name) {
		try {
			if (Files.exists(file)) {
				Files.delete(file);
			}
			Files.createFile(file);
		} catch(Exception e) {
			System.err.println(e);
		}
	}

	public static void write(String p_line) {
		try {
			Files.write(file, (p_line + "\n").getBytes(), StandardOpenOption.APPEND);
		} catch(Exception e) {
			System.err.println(e);
		}
	}
}
