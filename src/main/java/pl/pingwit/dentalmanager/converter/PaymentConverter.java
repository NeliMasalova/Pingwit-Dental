package pl.pingwit.dentalmanager.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.entity.Appointment;
import pl.pingwit.dentalmanager.entity.Payment;
import pl.pingwit.dentalmanager.repository.AppointmentRepository;

@Component
public class PaymentConverter {
    private final AppointmentRepository appointmentRepository;

    public PaymentConverter(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public PaymentDto convertToDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setName(payment.getName());
        paymentDto.setDate(payment.getDate());
        paymentDto.setTypePayment(payment.getTypePayment());

        return paymentDto;
    }

//    public Payment convertToEntity(PaymentDto inputDto) {
//        Appointment appointment = appointmentRepository.findById(inputDto.getAppointment().getId())
//                .orElseThrow(() -> new IllegalArgumentException("Appointment not found with ID: " + inputDto.getAppointment()));
//        Payment payment = new Payment(inputDto.getName(),
//                appointment,
//                inputDto.getDate(),
//                inputDto.getTypePayment());
//
//        return payment;
//    }
}