package com.Hospital.Management.System.Exception;

public class NoMedicinesFoundException extends RuntimeException{
    public NoMedicinesFoundException(String message) {
        super(message);
    }
}
