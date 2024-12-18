package com.Hospital.Management.System.DocLogin.entity;

import com.Hospital.Management.System.entity.Patient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Appointments")
public class Appointment {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String age;
    private String symtomps;
    private String number;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Many-to-many relationship: An appointment can have many medicines
    @ManyToMany
    @JoinTable(
            name = "appointment_medicine",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> medicines;


    public Appointment() {
    }

    public Appointment(long id, String name, String age, String symtomps, String number, Patient patient, List<Medicine> medicines) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.symtomps = symtomps;
        this.number = number;
        this.patient = patient;
        this.medicines = medicines;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSymtomps() {
        return symtomps;
    }

    public void setSymtomps(String symtomps) {
        this.symtomps = symtomps;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
