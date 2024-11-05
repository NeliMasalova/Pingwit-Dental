package pl.pingwit.dentalmanager.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.dentalmanager.dto.AppointmentDto;
import pl.pingwit.dentalmanager.dto.DentalTreatmentDto;
import pl.pingwit.dentalmanager.dto.DoctorDto;
import pl.pingwit.dentalmanager.dto.PatientDto;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.entity.Appointment;
import pl.pingwit.dentalmanager.entity.DentalTreatment;
import pl.pingwit.dentalmanager.entity.Doctor;
import pl.pingwit.dentalmanager.entity.Patient;
import pl.pingwit.dentalmanager.entity.Payment;
import pl.pingwit.dentalmanager.repository.DentalTreatmentRepository;
import pl.pingwit.dentalmanager.repository.DoctorRepository;
import pl.pingwit.dentalmanager.repository.PatientRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class AppointmentConverter {

    public AppointmentDto mapToDto(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(appointment.getId());
        appointmentDto.setDate(appointment.getDate());
        appointmentDto.setAppointmentStatus(appointment.getAppointmentStatus());
        appointmentDto.setPatient(mapPatientToDto(appointment.getPatient()));
        appointmentDto.setDoctor(mapDoctorToDto(appointment.getDoctor()));
        appointmentDto.setDentalTreatment(mapDentalTreatmentsToDto(appointment.getDentalTreatments()));
        appointmentDto.setPayment(mapPaymentToDto(appointment.getPayment()));
        return appointmentDto;
    }

    public Appointment mapToEntity(AppointmentDto inputDto) {
        Appointment appointment = new Appointment();
        appointment.setId(inputDto.getId());
        appointment.setDate(inputDto.getDate());
        appointment.setAppointmentStatus(inputDto.getAppointmentStatus());
        appointment.setPatient(mapPatientToEntity(inputDto.getPatient()));
        appointment.setDoctor(mapDoctorToEntity(inputDto.getDoctor()));
        appointment.setDentalTreatments(mapDentalTreatmentsToEntity(inputDto.getDentalTreatment()));
        appointment.setPayment(mapPaymentToEntity(inputDto.getPayment()));
        return appointment;
    }

    private PaymentDto mapPaymentToDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setTypePayment(payment.getTypePayment());
        paymentDto.setName(payment.getName());
        return paymentDto;
    }

    private Set<DentalTreatmentDto> mapDentalTreatmentsToDto(Set<DentalTreatment> dentalTreatments) {
        Set<DentalTreatmentDto> treatmentDtos = new HashSet<>();
        for (DentalTreatment treatment : dentalTreatments) {
            DentalTreatmentDto dto = new DentalTreatmentDto();
            dto.setName(treatment.getName());
            dto.setDescription(treatment.getDescription());
            dto.setPrice(treatment.getPrice());
            treatmentDtos.add(dto);
        }
        return treatmentDtos;
    }

    private DoctorDto mapDoctorToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSurname(doctor.getSurname());
        doctorDto.setSpecialty(doctor.getSpecialty());
        doctorDto.setRate(doctor.getRate());
        doctorDto.setPhone(doctor.getPhone());
        return doctorDto;
    }

    private PatientDto mapPatientToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setBirthdate(patient.getBirthdate());
        return patientDto;
    }

    private Patient mapPatientToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setBirthdate(patientDto.getBirthdate());
        return patient;
    }

    private Doctor mapDoctorToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        doctor.setSpecialty(doctorDto.getSpecialty());
        return doctor;
    }

    private Set<DentalTreatment> mapDentalTreatmentsToEntity(Set<DentalTreatmentDto> treatmentDtos) {
        Set<DentalTreatment> treatments = new HashSet<>();
        for (DentalTreatmentDto dto : treatmentDtos) {
            DentalTreatment treatment = new DentalTreatment();
            treatment.setId(dto.getId());
            treatment.setName(dto.getName());
            treatment.setPrice(dto.getPrice());
            treatments.add(treatment);
        }
        return treatments;
    }

    private Payment mapPaymentToEntity(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setId(paymentDto.getId());
        payment.setAmount(paymentDto.getAmount());
        payment.setTypePayment(paymentDto.getTypePayment());
        return payment;
    }

}