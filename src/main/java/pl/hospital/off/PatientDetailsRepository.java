package pl.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hospital.entity.PatientDetails;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {

}
