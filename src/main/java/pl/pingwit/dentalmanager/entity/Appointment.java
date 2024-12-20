package pl.pingwit.dentalmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentStatus appointmentStatus;
    @OneToOne(fetch = FetchType.EAGER)
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) - таким образом ты будешь сохранять, обновлять, удалять связанные сущность одним вызовом save. Я скоро добавлю видео про каскады
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToMany
    @JoinTable(
            name = "appointment_treatment",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id")
    )
    private Set<DentalTreatment> dentalTreatments = new HashSet<>();

    public Appointment() {
    }

    // этот конструктор нигде не используется, может удалим?
    public Appointment(Long id, LocalDate date, AppointmentStatus appointmentStatus, Payment payment, Patient patient, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.appointmentStatus = appointmentStatus;
        this.payment = payment;
        this.patient = patient;
        this.doctor = doctor;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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

    public Set<DentalTreatment> getDentalTreatments() {
        return dentalTreatments;
    }

    public void setDentalTreatments(Set<DentalTreatment> dentalTreatments) {
        this.dentalTreatments = dentalTreatments;
    }
}