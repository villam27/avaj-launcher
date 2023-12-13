package com.avaj.exceptions;

public class ParsingException extends Exception {
	public ParsingException(String p_line, int line, String p_file) {
        super(p_line + " in " + p_file + ":" + line);
    }
}