package com.avaj.exceptions;

public class NotAPositiveInteger extends Exception {
	public NotAPositiveInteger(String p_line, int line, String p_file) {
        super(p_line + " in " + p_file + ":" + line);
    }
}
