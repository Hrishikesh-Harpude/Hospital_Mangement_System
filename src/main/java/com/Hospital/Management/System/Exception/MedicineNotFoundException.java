package com.Hospital.Management.System.Exception;

public class MedicineNotFoundException extends RuntimeException{

    public MedicineNotFoundException(String message) {
        super(message);
    }
}
