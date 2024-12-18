package com.Hospital.Management.System.Doctor.repositry;

import com.Hospital.Management.System.DocLogin.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepositry extends JpaRepository<Appointment,Long> {
}
