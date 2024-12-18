package com.Hospital.Management.System.doclogi.controller;

import com.Hospital.Management.System.DocLogin.entity.Medicine;
import com.Hospital.Management.System.Doctor.repositry.MedicineRepositry;
import com.Hospital.Management.System.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;



    @PostMapping("/insert")
      public Medicine createMedicine(@RequestBody Medicine medicine)
    {
        return medicineService.save(medicine);
    }

    @GetMapping
    public List<Medicine> getAllMedicines()
    {
        return medicineService.findAll();
    }

    @GetMapping("/{id}")
    public Medicine getById(@PathVariable long id)
    {
        return medicineService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String Deletemedicine(@PathVariable long id)
    {
        return medicineService.deleteById(id);
    }

    @PutMapping("/update")
    public Medicine updateMedicine(@RequestBody Medicine medicine)
    {
        return medicineService.updateMedicine(medicine);
    }
}
