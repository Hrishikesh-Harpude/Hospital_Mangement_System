package com.Hospital.Management.System.Exception;

public class NoPatientsFoundException extends RuntimeException {
    public NoPatientsFoundException(String message) {
        super(message);
    }
}

