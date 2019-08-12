package pl.hospital.service;

import javassist.NotFoundException;
import pl.hospital.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface CRUDService<T> {

    public List<T> findAll();
    void save(T obj);
    void save(List<T> list);
    Optional<T> getById(long id);
    void deleteById(long id) throws NotFoundException;

}
