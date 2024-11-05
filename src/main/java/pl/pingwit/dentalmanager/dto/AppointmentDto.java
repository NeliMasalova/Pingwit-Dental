package pl.pingwit.dentalmanager.dto;

import pl.pingwit.dentalmanager.entity.AppointmentStatus;

import java.time.LocalDate;
import java.util.Set;

public class AppointmentDto {
    private Long id;
    private LocalDate date;
    private AppointmentStatus appointmentStatus;
    private PatientDto patient;
    private DoctorDto doctor;
    private Set<DentalTreatmentDto> dentalTreatment;
    private PaymentDto payment;

    public AppointmentDto() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public Set<DentalTreatmentDto> getDentalTreatment() {
        return dentalTreatment;
    }

    public void setDentalTreatment(Set<DentalTreatmentDto> dentalTreatment) {
        this.dentalTreatment = dentalTreatment;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }
}