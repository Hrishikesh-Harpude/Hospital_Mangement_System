package com.Hospital.Management.System.Exception;

public class AppointmentsNotFoundException extends RuntimeException{
    public AppointmentsNotFoundException(String message) {
        super(message);
    }
}
