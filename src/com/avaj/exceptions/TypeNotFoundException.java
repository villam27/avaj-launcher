package com.avaj.exceptions;

public class TypeNotFoundException extends Exception {
    public TypeNotFoundException(String p_type) {
        super(p_type);
    }
}
