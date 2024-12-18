package com.Hospital.Management.System.repositry;

import com.Hospital.Management.System.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositry extends JpaRepository<Patient,Long> {
}
