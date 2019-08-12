package pl.hospital.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hospital.entity.Doctor;
import pl.hospital.entity.Patient;
import pl.hospital.service.CRUDService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private CRUDService doctorService;

    public DoctorController(@Qualifier("doctorServiceImpl") CRUDService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public Iterable<Doctor> findAll(){

        return doctorService.findAll();
    }

    @PostMapping("/doctor")
    public Doctor save(@RequestBody Doctor doctor){
        doctorService.save(doctor);
        return doctor;
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Optional> findById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK)
                .header("Custom-Header", "foo")
                .body(doctorService.getById(id));
    }

    @PutMapping("/doctor/{id}")
    public String upDateDoctorMethod(@RequestBody Doctor upDateDoctor, @PathVariable long id) {
       Optional<Doctor> doctorToUpDate = doctorService.getById(id);
       if(doctorToUpDate.isPresent()){
           Doctor dr = doctorToUpDate.get();
           dr.setName(upDateDoctor.getName());
           dr.setLastName(upDateDoctor.getLastName());
           dr.setProfession(upDateDoctor.getProfession());

           doctorService.save(dr);
           return "Doctor updated: " + dr;
       }
       else
           return String.valueOf(new NotFoundException("No Doctor with id: " + id));
    }

    @DeleteMapping("/doctor/{id}")
    public String delete(@PathVariable long id) throws NotFoundException {
        doctorService.deleteById(id);
        return "Doctor deleted with id: " + id;
    }

}
