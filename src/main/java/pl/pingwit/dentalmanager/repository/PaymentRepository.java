package pl.pingwit.dentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.dentalmanager.entity.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByAppointmentId(Long appointmentId);
}
