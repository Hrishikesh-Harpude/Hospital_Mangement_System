package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repositry.PatientRepositry;
import com.Hospital.Management.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient)
    {
        return patientService.save(patient);
    }
    @GetMapping
   public List<Patient> getAllPatients()
   {
       return patientService.findall();

   }
   @GetMapping("/{id}")
   public Patient FindById(@PathVariable long id)
   {
       return patientService.findPatientById(id);
   }
   @PutMapping("/update")
   public Patient UpdatePatient(@RequestBody Patient patient)
   {
       return patientService.UpdatePatient(patient);
   }





   @DeleteMapping("/delete/{id}")
    public String DeletePatient(@PathVariable long id)
   {
       return patientService.PatientDelete(id);
   }
}
