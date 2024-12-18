package com.Hospital.Management.System.service;

import com.Hospital.Management.System.Exception.NoPatientsFoundException;
import com.Hospital.Management.System.Exception.PatientNotFoundException;
import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repositry.PatientRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepositry patientRepositry;
    public Patient save(Patient patient) {

        if (patient==null)
        {
            throw new IllegalArgumentException("Patient Object Cannot be Null");
        }
        if (patient.getName()==null || patient.getName().isEmpty()) {
            throw new IllegalArgumentException("Patient name is required");
        }
        return patientRepositry.save(patient);
    }







    public List<Patient> findall() {

        List<Patient> patients = patientRepositry.findAll();

        if (patients == null || patients.isEmpty()) {
            throw new NoPatientsFoundException("No patients found in the database.");
        }
        return patients;
    }








    public Patient findPatientById(long id) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        Optional<Patient> patientOptional = patientRepositry.findById(id);

        if (patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Patient with ID " + id + " not found.");
        }
        System.out.println("Patient found with ID: " + id);

        return patientOptional.get();
    }




    public String PatientDelete(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        if (!patientRepositry.existsById(id)) {
            throw new PatientNotFoundException("Patient with ID " + id + " does not exist.");
        }
        patientRepositry.deleteById(id);
        return "Deleted Patient Successfully with ID: " + id;
    }


    public Patient UpdatePatient(Patient patient) {

        if (patient == null || patient.getId() <= 0) {
            throw new IllegalArgumentException("Invalid patient object or ID.");
        }


        Patient existingPatient = patientRepositry.findById(patient.getId())
                .orElseThrow(() -> new PatientNotFoundException("Patient with ID " + patient.getId() + " not found."));


        if (patient.getAge() != null) {
            existingPatient.setAge(patient.getAge());
        }
        if (patient.getBlood() != null && !patient.getBlood().isEmpty()) {
            existingPatient.setBlood(patient.getBlood());
        }
        if (patient.getDose() != null && !patient.getDose().isEmpty()) {
            existingPatient.setDose(patient.getDose());
        }
        if (patient.getPrescription() != null && !patient.getPrescription().isEmpty()) {
            existingPatient.setPrescription(patient.getPrescription());
        }
        if (patient.getUrgency() != null && !patient.getUrgency().isEmpty()) {
            existingPatient.setUrgency(patient.getUrgency());
        }
        if (patient.getName() != null && !patient.getName().isEmpty()) {
            existingPatient.setName(patient.getName());
        }


        Patient updatedPatient = patientRepositry.save(existingPatient);
        return updatedPatient;
    }








}





