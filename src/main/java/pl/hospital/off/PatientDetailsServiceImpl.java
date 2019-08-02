package pl.hospital.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import pl.hospital.repository.PatientDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientDetailsServiceImpl implements CRUDService<PatientDetailsRepository> {

    private PatientDetailsRepository patientDetailsRepository;

    public PatientDetailsServiceImpl(PatientDetailsRepository patientDetailsRepository) {
        this.patientDetailsRepository = patientDetailsRepository;
    }

    @Override
    public List<PatientDetailsRepository> findAll() {
        return patientDetailsRepository.findAll();
    }

    @Override
    public void save(PatientDetailsRepository patient) {
        patientDetailsRepository.save(patient);
    }

    @Override
    public Optional<PatientDetailsRepository> getById(long id) {
        return patientDetailsRepository.findById(id);
    }

    @Override
    public void deleteById(long id) throws NotFoundException {
        if (patientDetailsRepository.findById(id) == null){
            throw new NotFoundException("Patient not exist");
        }
        else
            patientDetailsRepository.deleteById(id);
    }

}
