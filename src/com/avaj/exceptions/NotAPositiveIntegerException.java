package com.avaj.exceptions;

public class NotAPositiveIntegerException extends Exception {
	public NotAPositiveIntegerException(String p_line, int line, String p_file) {
        super(p_line + " in " + p_file + ":" + line);
    }
}
