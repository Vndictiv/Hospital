package pl.hospital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hospital.entity.Patient;
import pl.hospital.entity.PatientDetails;
import pl.hospital.repository.PatientDetailsRepository;
import pl.hospital.service.CRUDService;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequestMapping("/api")
public class PatientController {

    private CRUDService patientService;
    private PatientDetailsRepository patientDetailsRepository;

    public PatientController(@Qualifier("patientServiceImpl") CRUDService patientService, PatientDetailsRepository patientDetailsRepository) {
        this.patientService = patientService;
        this.patientDetailsRepository = patientDetailsRepository;
    }

//    public PatientController(@Qualifier("patientServiceImpl") CRUDService patientService) {
//        this.patientService = patientService;
//    }

    @GetMapping("/patients")
    public @ResponseBody List<Patient> findAll(){

        return patientService.findAll();
    }

    @PostMapping("/patient")
    public Patient save(@RequestBody Patient patient) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Patient myPatient = objectMapper.readValue((DataInput) patient, Patient.class);
    //    PatientDetails pat = patient.getPatientDetails();


        patientService.save(patient);
        return patient;
    }

    @PostMapping("/patients")
    public void save(@RequestBody List<Patient> patientList){
        patientService.save(patientList);
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
           pat.setDateOfBirth(upDatePatient.getDateOfBirth());
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

    @PostMapping("/patientDetails")
    public void patientDetails(@RequestBody PatientDetails patientDetails){
        patientDetailsRepository.save(patientDetails);
    }
}
