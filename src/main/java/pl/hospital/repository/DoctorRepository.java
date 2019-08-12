package pl.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hospital.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}
