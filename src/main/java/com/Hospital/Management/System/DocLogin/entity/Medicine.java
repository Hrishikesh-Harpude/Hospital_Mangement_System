package com.Hospital.Management.System.DocLogin.entity;

import com.Hospital.Management.System.entity.Patient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="medicines" )
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "drug_name")
    private String drugName;
    private String stock;


    @ManyToMany(mappedBy = "medicines")
    private List<Patient> patients;


    @ManyToMany(mappedBy = "medicines")
    private List<Appointment> appointments;

    public Medicine() {
    }

    public Medicine(long id, String drugName, String stock, List<Patient> patients, List<Appointment> appointments) {
        this.id = id;
        this.drugName = drugName;
        this.stock = stock;
        this.patients = patients;
        this.appointments = appointments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}

