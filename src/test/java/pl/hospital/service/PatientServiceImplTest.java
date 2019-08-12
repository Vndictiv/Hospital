package pl.hospital.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.hospital.entity.Patient;
import pl.hospital.entity.PatientDetails;
import pl.hospital.repository.PatientRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceImplTest {

    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    CRUDService<Patient> patientService;

    Patient patientToReturn;


    @Test
    void findAll() {
        PatientDetails patientDetails = new PatientDetails();
        Date date = new Date();
        List<Patient> returnPatients = new ArrayList<>();
     //   returnPatients.add(new Patient(1,"Jan", "Kowalczyk", date, "Male", patientDetails ));
     //   returnPatients.add(new Patient(2,"Piotr", "Nowak",  date, "Male", patientDetails));


        when(patientRepository.findAll()).thenReturn(returnPatients);

        List<Patient> patients = patientService.findAll();

        assertNotNull(patients);
        assertEquals(2, patients.iterator());



    }
}