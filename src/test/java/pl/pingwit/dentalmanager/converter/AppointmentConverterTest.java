package pl.pingwit.dentalmanager.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.pingwit.dentalmanager.dto.AppointmentDto;
import pl.pingwit.dentalmanager.entity.Appointment;
import pl.pingwit.dentalmanager.entity.DentalTreatment;
import pl.pingwit.dentalmanager.entity.Doctor;
import pl.pingwit.dentalmanager.entity.Patient;
import pl.pingwit.dentalmanager.repository.DentalTreatmentRepository;
import pl.pingwit.dentalmanager.repository.DoctorRepository;
import pl.pingwit.dentalmanager.repository.PatientRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.pingwit.dentalmanager.entity.AppointmentStatus.COMPLETED;

class AppointmentConverterTest {
    @Mock
    private PatientRepository patientRepository;
    @Mock
    private DoctorRepository doctorRepository;
    @Mock
    private DentalTreatmentRepository dentalTreatmentRepository;

    @InjectMocks
    private AppointmentConverter appointmentConverter;
    private Appointment appointment;
    private AppointmentDto appointmentDto;
    private Patient patient;
    private Doctor doctor;
    private DentalTreatment dentalTreatment;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        patient = new Patient();
        patient.setId(1L);

        doctor = new Doctor();
        doctor.setId(1L);

        dentalTreatment = new DentalTreatment();
        dentalTreatment.setId(1L);

        appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDate(LocalDate.of(2024,10,01));
        appointment.setAppointmentStatus(COMPLETED);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDentalTreatments(Set.of(dentalTreatment));

        appointmentDto = new AppointmentDto();
        appointmentDto.setId(1L);
        appointmentDto.setDate(LocalDate.of(2024,10,01));
        appointmentDto.setAppointmentStatus(COMPLETED);
        appointmentDto.setPatient(patient);
        appointmentDto.setDoctor(doctor);
        appointmentDto.setDentalTreatment(Set.of(dentalTreatment));
    }
    @Test
    void mapToDto() {
        AppointmentDto dto = appointmentConverter.mapToDto(appointment);

        assertNotNull(dto);
        assertEquals(appointment.getId(), dto.getId());
        assertEquals(appointment.getDate(), dto.getDate());
        assertEquals(appointment.getAppointmentStatus(), dto.getAppointmentStatus());
        assertEquals(appointment.getPatient(), dto.getPatient());
        assertEquals(appointment.getDoctor(), dto.getDoctor());
        assertEquals(appointment.getDentalTreatments().size(), dto.getDentalTreatment().size());
    }

    @Test
    void mapToEntity() {
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
        when(doctorRepository.findById(doctor.getId())).thenReturn(Optional.of(doctor));
        when(dentalTreatmentRepository.findById(dentalTreatment.getId())).thenReturn(Optional.of(dentalTreatment));

        Appointment entity = appointmentConverter.mapToEntity(appointmentDto);

        assertNotNull(entity);
        assertEquals(appointmentDto.getDate(), entity.getDate());
        assertEquals(appointmentDto.getAppointmentStatus(), entity.getAppointmentStatus());
        assertEquals(appointmentDto.getPatient().getId(), entity.getPatient().getId());
        assertEquals(appointmentDto.getDoctor().getId(), entity.getDoctor().getId());
        assertEquals(appointmentDto.getDentalTreatment().size(), entity.getDentalTreatments().size());

        verify(patientRepository, times(1)).findById(patient.getId());
        verify(doctorRepository, times(1)).findById(doctor.getId());
        verify(dentalTreatmentRepository, times(1)).findById(dentalTreatment.getId());
    }

}