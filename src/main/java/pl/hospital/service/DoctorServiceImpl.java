package pl.hospital.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import pl.hospital.entity.Patient;
import pl.hospital.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements CRUDService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> getById(long id) {
        return patientRepository.findById(id);
    }

    @Override
    public void deleteById(long id) throws NotFoundException {
        if (patientRepository.findById(id) == null){
            throw new NotFoundException("Patient not exist");
        }
        else
            patientRepository.deleteById(id);
    }

}
