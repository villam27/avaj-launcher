package com.avaj.exceptions;

public class NotAValidHeight extends Exception {
	public NotAValidHeight(String p_line, int line, String p_file) {
        super(p_line + " in " + p_file + ":" + line);
    }
}
