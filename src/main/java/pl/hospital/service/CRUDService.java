package pl.hospital.service;

import javassist.NotFoundException;
import pl.hospital.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface CRUDService {

    public List<Patient> findAll();
    void save(Patient patient);
    Optional<Patient> getById(long id);
    void deleteById(long id) throws NotFoundException;

}
