package com.avaj.exceptions;

public class NotAValidHeightException extends Exception {
	public NotAValidHeightException(String p_line, int line, String p_file) {
        super(p_line + " in " + p_file + ":" + line);
    }
}
