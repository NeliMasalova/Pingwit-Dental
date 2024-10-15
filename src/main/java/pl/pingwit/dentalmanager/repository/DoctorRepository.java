package pl.pingwit.dentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.dentalmanager.entity.Appointment;
import pl.pingwit.dentalmanager.entity.Doctor;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findById(Appointment id);
}
