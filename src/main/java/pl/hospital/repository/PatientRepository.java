package pl.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hospital.entity.Patient;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
