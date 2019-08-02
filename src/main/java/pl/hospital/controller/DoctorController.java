package pl.hospital.controller;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hospital.entity.Patient;
import pl.hospital.service.CRUDService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {

    private CRUDService patientService;

    public PatientController(CRUDService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> findAll(){

        return patientService.findAll();
    }

    @PostMapping("/patient")
    public Patient save(@RequestBody Patient patient){
        patientService.save(patient);
        return patient;
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Optional> findById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK)
                .header("Custom-Header", "foo")
                .body(patientService.getById(id));
    }

    @PutMapping("/patient/{id}")
    public String upDatePatient(@RequestBody Patient upDatePatient, @PathVariable long id) {
       Optional<Patient> patientToUpDate = patientService.getById(id);
       if(patientToUpDate.isPresent()){
           Patient pat = patientToUpDate.get();
           pat.setName(upDatePatient.getName());
           pat.setLastName(upDatePatient.getLastName());
           pat.getDateOfBirth();
           pat.setGender();
           patientService.save(pat);
           return "Patient updated: " + pat;
       }
       else
           return String.valueOf(new NotFoundException("No Patient with id: " + id));
    }

    @DeleteMapping("/patient/{id}")
    public String delete(@PathVariable long id) throws NotFoundException {
        patientService.deleteById(id);
        return "Patient deleted with id: " + id;
    }

}
