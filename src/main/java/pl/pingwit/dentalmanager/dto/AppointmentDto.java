package pl.pingwit.dentalmanager.dto;

import pl.pingwit.dentalmanager.entity.AppointmentStatus;
import pl.pingwit.dentalmanager.entity.DentalTreatment;
import pl.pingwit.dentalmanager.entity.Doctor;
import pl.pingwit.dentalmanager.entity.Patient;

import java.time.LocalDate;
import java.util.Set;

public class AppointmentDto {
    private Long id;
    private LocalDate date;
    private AppointmentStatus appointmentStatus;
    private Patient patient;
    private Doctor doctor;
    private Set<DentalTreatment> dentalTreatment;
    private PaymentDto payment;

    public AppointmentDto() {
    }

    public AppointmentDto(Long id, LocalDate date, AppointmentStatus appointmentStatus, Patient patient, Doctor doctor, Set<DentalTreatment> dentalTreatment, PaymentDto payment) {
        this.id = id;
        this.date = date;
        this.appointmentStatus = appointmentStatus;
        this.patient = patient;
        this.doctor = doctor;
        this.dentalTreatment = dentalTreatment;
        this.payment = payment;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Set<DentalTreatment> getDentalTreatment() {
        return dentalTreatment;
    }

    public void setDentalTreatment(Set<DentalTreatment> dentalTreatment) {
        this.dentalTreatment = dentalTreatment;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }
}