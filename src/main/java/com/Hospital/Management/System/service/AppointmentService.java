package com.Hospital.Management.System.service;

import com.Hospital.Management.System.DocLogin.entity.Appointment;
import com.Hospital.Management.System.Doctor.repositry.AppointmentRepositry;
import com.Hospital.Management.System.Exception.AppointmentNotFoundException;
import com.Hospital.Management.System.Exception.AppointmentsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepositry appointmentRepositry;

    public Appointment save(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        Appointment savedAppointment = appointmentRepositry.save(appointment);
        return savedAppointment;
    }

    public List<Appointment> findAll() {
        List<Appointment> appointments = appointmentRepositry.findAll();

        if (appointments.isEmpty()) {
            throw new AppointmentsNotFoundException("No appointments available.");
        }
        return appointments;
    }



    public String DeleteAppointment(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        Appointment existingAppointment = appointmentRepositry.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with ID " + id + " not found."));

        appointmentRepositry.deleteById(id);
        return "Deleted successfully. Appointment ID: " + id;
    }

    public Appointment findById(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        Appointment appointment = appointmentRepositry.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with ID " + id + " not found."));
        return appointment;
    }

    public Appointment updateAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        if (appointment.getId() <= 0) {
            throw new IllegalArgumentException("Appointment ID must be a positive number.");
        }
        Appointment existingAppointment = appointmentRepositry.findById(appointment.getId())
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with ID " + appointment.getId() + " not found."));

        if (appointment.getAge() != null) {
            existingAppointment.setAge(appointment.getAge());
        }
        if (appointment.getName() != null && !appointment.getName().isEmpty()) {
            existingAppointment.setName(appointment.getName());
        }
        if (appointment.getSymtomps() != null && !appointment.getSymtomps().isEmpty()) {
            existingAppointment.setSymtomps(appointment.getSymtomps());
        }
        if (appointment.getNumber() != null && !appointment.getNumber().isEmpty()) {
            existingAppointment.setNumber(appointment.getNumber());
        }
        return appointmentRepositry.save(existingAppointment);
    }
}
