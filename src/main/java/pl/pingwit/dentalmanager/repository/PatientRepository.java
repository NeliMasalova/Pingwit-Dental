package pl.pingwit.dentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.dentalmanager.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
