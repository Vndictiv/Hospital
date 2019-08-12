package pl.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import pl.hospital.entity.PatientDetails;

public interface PatientDetailsRepository extends CrudRepository<PatientDetails, Long> {
}
