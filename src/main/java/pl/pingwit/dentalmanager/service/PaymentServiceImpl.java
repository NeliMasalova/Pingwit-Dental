package pl.pingwit.dentalmanager.service;

import org.springframework.stereotype.Service;
import pl.pingwit.dentalmanager.converter.PaymentConverter;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.repository.AppointmentRepository;
import pl.pingwit.dentalmanager.repository.DentalTreatmentRepository;
import pl.pingwit.dentalmanager.repository.PaymentRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentConverter paymentConverter;
    private final AppointmentRepository appointmentRepository;
    private final DentalTreatmentRepository dentalTreatmentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentConverter paymentConverter, AppointmentRepository appointmentRepository, DentalTreatmentRepository dentalTreatmentRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentConverter = paymentConverter;
        this.appointmentRepository = appointmentRepository;
        this.dentalTreatmentRepository = dentalTreatmentRepository;
    }

    @Override
    public List<PaymentDto> paymentList() {
        return paymentRepository.findAll().stream()
                .map(paymentConverter::convertToDto)
                .toList();
    }

//    @Override
//    public Long createPayment(PaymentDto paymentDto) {
//        Appointment appointment = appointmentRepository.findById(paymentDto.getAppointment().getId())
//                .orElseThrow(() -> new RuntimeException("Appointment not found"));
//
//        List<DentalTreatment> dentalTreatments = dentalTreatmentRepository.findByAppointmentsId(appointment.getId());
//        BigDecimal totalAmount = dentalTreatments.stream()
//                .map(DentalTreatment::getPrice)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        Payment payment = new Payment();
//        payment.setName(paymentDto.getName());
//        payment.setDate(paymentDto.getDate());
//        payment.setTypePayment(paymentDto.getTypePayment());
//        payment.setAppointment(paymentDto.getAppointment());
//        payment.setAmount(totalAmount);
//
//        Payment savedPayment = paymentRepository.save(payment);
//
//        updateTotalAmountForVisit(appointment.getId());
//
//        return savedPayment.getId();
//    }

//    public void updateTotalAmountForVisit(Long longId) {
//        List<Payment> paymentsForVisit = paymentRepository.findByAppointmentId(longId);
//
//        BigDecimal totalAmount = paymentsForVisit.stream()
//                .map(Payment::getAmount)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        Appointment appointment = appointmentRepository.findById(longId)
//                .orElseThrow(() -> new NotFoundException("Appointment not found"));
//
//        appointment.setAmount(totalAmount);
//        appointmentRepository.save(appointment);
//    }
}