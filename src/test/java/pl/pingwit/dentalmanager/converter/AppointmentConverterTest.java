package pl.pingwit.dentalmanager.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pingwit.dentalmanager.dto.AppointmentDto;
import pl.pingwit.dentalmanager.dto.DentalTreatmentDto;
import pl.pingwit.dentalmanager.dto.DoctorDto;
import pl.pingwit.dentalmanager.dto.PatientDto;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.entity.Appointment;
import pl.pingwit.dentalmanager.entity.AppointmentStatus;
import pl.pingwit.dentalmanager.entity.DentalTreatment;
import pl.pingwit.dentalmanager.entity.Doctor;
import pl.pingwit.dentalmanager.entity.Patient;
import pl.pingwit.dentalmanager.entity.Payment;
import pl.pingwit.dentalmanager.entity.TypePayment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppointmentConverterTest {
    private AppointmentConverter appointmentConverter;

    @BeforeEach
    void setUp() {
        appointmentConverter = new AppointmentConverter();
    }

    @Test
    void mapToDto() {
        Appointment appointment = new Appointment();

        appointment.setId(1L);
        appointment.setDate(LocalDate.of(2024, 10, 1));
        appointment.setAppointmentStatus(AppointmentStatus.COMPLETED);
        appointment.setPatient(new Patient(1L, "Barbara", "Smyk", LocalDate.of(1990, 1, 1), "barbara.s@gmail.com", "592152152", "15-789, Białystok, ul. Pietkuna 19/10"));
        appointment.setDoctor(new Doctor(1L, "Marek", "Grzesiak", "496785777", "Ortodonta", 5.0));
        appointment.setDentalTreatments(Set.of(new DentalTreatment(1L, "Podcięcie łuku.", "", BigDecimal.valueOf(100.0))));
        appointment.setPayment(new Payment(1L));

        AppointmentDto appointmentDto = appointmentConverter.mapToDto(appointment);

        assertNotNull(appointmentDto);
        assertEquals(appointment.getId(), appointmentDto.getId());
        assertEquals(appointment.getDate(), appointmentDto.getDate());
        assertEquals(appointment.getAppointmentStatus(), appointmentDto.getAppointmentStatus());
        assertEquals(appointment.getPatient().getName(), appointmentDto.getPatient().getName());
        assertEquals(appointment.getDoctor().getName(), appointmentDto.getDoctor().getName());
        assertEquals(appointment.getDentalTreatments().size(), appointmentDto.getDentalTreatment().size());
    }

    @Test
    void mapToEntity() {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(1L);
        patientDto.setName("Barbara");
        patientDto.setSurname("Smyk");
        patientDto.setBirthdate(LocalDate.of(1990, 1, 1));

        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(1L);
        doctorDto.setName("Marek");
        doctorDto.setSurname("Grzesiak");
        doctorDto.setSpecialty("Ortodonta");

        DentalTreatmentDto dentalTreatmentDto = new DentalTreatmentDto();
        dentalTreatmentDto.setId(1L);
        dentalTreatmentDto.setName("Podcięcie łuku.");
        dentalTreatmentDto.setPrice(BigDecimal.valueOf(100.0));

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(1L);
        paymentDto.setName("Opłata");
        paymentDto.setTypePayment(TypePayment.CARD);

        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(1L);
        appointmentDto.setDate(LocalDate.of(2024, 10, 1));
        appointmentDto.setAppointmentStatus(AppointmentStatus.COMPLETED);
        appointmentDto.setPatient(patientDto);
        appointmentDto.setDoctor(doctorDto);
        appointmentDto.setDentalTreatment(Set.of(dentalTreatmentDto));
        appointmentDto.setPayment(paymentDto);

        Appointment entity = appointmentConverter.mapToEntity(appointmentDto);

        assertNotNull(entity);
        assertEquals(appointmentDto.getId(), entity.getId());
        assertEquals(appointmentDto.getDate(), entity.getDate());
        assertEquals(appointmentDto.getAppointmentStatus(), entity.getAppointmentStatus());
        assertEquals(appointmentDto.getPatient().getId(), entity.getPatient().getId());
        assertEquals(appointmentDto.getDoctor().getId(), entity.getDoctor().getId());
        assertEquals(appointmentDto.getDentalTreatment().size(), entity.getDentalTreatments().size());
    }
}