package pl.pingwit.dentalmanager.service;

import org.springframework.stereotype.Service;
import pl.pingwit.dentalmanager.converter.PaymentConverter;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.repository.AppointmentRepository;
import pl.pingwit.dentalmanager.repository.DentalTreatmentRepository;
import pl.pingwit.dentalmanager.repository.PaymentRepository;

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

    @Override
    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
}