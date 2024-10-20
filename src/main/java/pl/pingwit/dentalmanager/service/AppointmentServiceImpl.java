package pl.pingwit.dentalmanager.service;

import org.springframework.stereotype.Service;
import pl.pingwit.dentalmanager.converter.AppointmentConverter;
import pl.pingwit.dentalmanager.dto.AppointmentDto;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.entity.Appointment;
import pl.pingwit.dentalmanager.entity.DentalTreatment;
import pl.pingwit.dentalmanager.entity.Doctor;
import pl.pingwit.dentalmanager.entity.Patient;
import pl.pingwit.dentalmanager.entity.Payment;
import pl.pingwit.dentalmanager.exceptionhandling.NotFoundException;
import pl.pingwit.dentalmanager.repository.AppointmentRepository;
import pl.pingwit.dentalmanager.repository.DentalTreatmentRepository;
import pl.pingwit.dentalmanager.repository.DoctorRepository;
import pl.pingwit.dentalmanager.repository.PatientRepository;
import pl.pingwit.dentalmanager.repository.PaymentRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentConverter appointmentConverter;
    private final DentalTreatmentRepository dentalTreatmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final PaymentRepository paymentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  AppointmentConverter appointmentConverter,
                                  DentalTreatmentRepository dentalTreatmentRepository,
                                  PatientRepository patientRepository,
                                  DoctorRepository doctorRepository,
                                  PaymentRepository paymentRepository) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
        this.dentalTreatmentRepository = dentalTreatmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public AppointmentDto getAppointmentByPatientId(Long patientId) {
        Appointment appointment = appointmentRepository.findByPatientId(patientId).
                orElseThrow(() -> new NotFoundException("Patient with such id not found. Please, try again."));
        return appointmentConverter.mapToDto(appointment);
    }

//    @Override
//    public Long createAppointment(AppointmentDto inputDto) {
//        Appointment appointment = appointmentConverter.mapToEntity(inputDto);
//        Appointment savedAppointment = appointmentRepository.save(appointment);
//        return savedAppointment.getId();
//    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentDto> listAppointments() {
        return appointmentRepository.findAll().stream()
                .map(appointmentConverter::mapToDto)
                .toList();
    }

    @Override
    public Appointment createAppointmentWithPayment(AppointmentDto appointmentDto) {
        Appointment appointment = appointmentConverter.mapToEntity(appointmentDto);

        BigDecimal totalAmount = BigDecimal.ZERO;
        Set<DentalTreatment> dentalTreatments = appointmentDto.getDentalTreatment();
        if (dentalTreatments != null) {
            for (DentalTreatment dentalTreatment : dentalTreatments) {
                DentalTreatment treatment = dentalTreatmentRepository.findById(dentalTreatment.getId())
                        .orElseThrow(() -> new NotFoundException("Dental treatment with such id doesn't exist."));
                totalAmount = totalAmount.add(treatment.getPrice());
            }
        }

        Payment payment = new Payment();
        payment.setName(appointmentDto.getPayment().getName());
        payment.setDate(appointmentDto.getPayment().getDate());
        payment.setTypePayment(appointmentDto.getPayment().getTypePayment());
        payment.setAmount(totalAmount);

        Payment savedPayment = paymentRepository.save(payment);
        appointment.setPayment(savedPayment);

        return appointmentRepository.save(appointment);
    }
}
//    @PostConstruct
//    private void init() {
//        System.out.println(".");
//    }
