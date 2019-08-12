package pl.hospital.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import pl.hospital.entity.Doctor;
import pl.hospital.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements CRUDService<Doctor> {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public void save(Doctor doctor) {
            doctorRepository.save(doctor);
        }

    @Override
    public void save(List<Doctor> list) {
        doctorRepository.saveAll(list);
    }

    @Override
    public Optional<Doctor> getById(long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void deleteById(long id) throws NotFoundException {
        if (doctorRepository.findById(id) == null){
            throw new NotFoundException("Doctor not exist");
        }
        else
            doctorRepository.deleteById(id);
    }

}
