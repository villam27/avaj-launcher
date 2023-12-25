package com.avaj.exceptions;

public class NoDataFoundException extends Exception {
	public NoDataFoundException(String p_file) {
        super(p_file);
    }
}
