package pl.pingwit.dentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.dentalmanager.entity.DentalTreatment;

import java.util.List;

public interface DentalTreatmentRepository extends JpaRepository<DentalTreatment, Long> {
    List<DentalTreatment> findByAppointmentsId(Long id);
}
