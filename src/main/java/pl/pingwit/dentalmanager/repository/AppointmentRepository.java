package pl.pingwit.dentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.dentalmanager.entity.Appointment;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByPatientId(Long patientId);
}
