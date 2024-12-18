package com.Hospital.Management.System.doclogi.controller;

import com.Hospital.Management.System.DocLogin.entity.Appointment;
import com.Hospital.Management.System.Doctor.repositry.AppointmentRepositry;
import com.Hospital.Management.System.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;



    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment)
    {
        return appointmentService.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllMedicines()
    {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable long id)
    {
        return appointmentService.findById(id);
    }
    @PutMapping("/update")
    public Appointment updateAppointment(@RequestBody Appointment appointment)
    {
        return appointmentService.updateAppointment(appointment);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteAppointment(@PathVariable long id)
    {
        return appointmentService.DeleteAppointment(id);
    }
}
