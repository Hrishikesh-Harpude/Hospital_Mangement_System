package com.Hospital.Management.System.service;

import com.Hospital.Management.System.DocLogin.entity.Medicine;
import com.Hospital.Management.System.Doctor.repositry.MedicineRepositry;
import com.Hospital.Management.System.Exception.MedicineNotFoundException;
import com.Hospital.Management.System.Exception.NoMedicinesFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepositry medicineRepositry;

    public Medicine save(Medicine medicine) {

        if (medicine == null) {
            throw new IllegalArgumentException("Medicine object cannot be null.");
        }
        if (medicine.getDrugName() == null || medicine.getDrugName().isEmpty()) {
            throw new IllegalArgumentException("Drug name is required and cannot be empty.");
        }
        if (medicine.getStock() == null || medicine.getStock().isEmpty()) {
            throw new IllegalArgumentException("Stock information is required and cannot be empty.");
        }

        Medicine savedMedicine = medicineRepositry.save(medicine);
        return savedMedicine;
    }




    public List<Medicine> findAll() {
        List<Medicine> medicines = medicineRepositry.findAll();
        if (medicines.isEmpty()) {
            throw new NoMedicinesFoundException("No medicines found in the database.");
        }
        return medicines;
    }

    public Medicine findById(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        Medicine medicine = medicineRepositry.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException("Medicine with ID " + id + " not found."));
        return medicine;
    }

    public String deleteById(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        Medicine existingMedicine = medicineRepositry.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException("Medicine with ID " + id + " not found."));
        medicineRepositry.deleteById(id);
        return "Successfully deleted medicine with ID: " + id;
    }

    public Medicine updateMedicine(Medicine medicine) {

        if (medicine == null || medicine.getId() <= 0) {
            throw new IllegalArgumentException("Invalid medicine object or ID.");
        }


        Medicine existingMedicine = medicineRepositry.findById(medicine.getId())
                .orElseThrow(() -> new MedicineNotFoundException("Medicine with ID " + medicine.getId() + " not found."));


        if (medicine.getDrugName() == null || medicine.getDrugName().isEmpty()) {
            throw new IllegalArgumentException("Drug name cannot be null or empty.");
        }
        if (medicine.getStock() == null || medicine.getStock().isEmpty()) {
            throw new IllegalArgumentException("Stock information cannot be null or empty.");
        }

        existingMedicine.setDrugName(medicine.getDrugName());
        existingMedicine.setStock(medicine.getStock());
        return medicineRepositry.save(existingMedicine);
    }



}
