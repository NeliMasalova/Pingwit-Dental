package pl.pingwit.dentalmanager.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pingwit.dentalmanager.dto.CreatePatientInputDto;
import pl.pingwit.dentalmanager.dto.PatientDto;
import pl.pingwit.dentalmanager.entity.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientConverterTest {
    private PatientConverter patientConverter;

    @BeforeEach
    void setUp() {
        patientConverter = new PatientConverter();
    }

    @Test
    void convertToDto() {
        Patient patient = new Patient();

        patient.setName("Barbara");
        patient.setSurname("Smyk");
        patient.setBirthdate(LocalDate.of(1990, 1, 1));
        patient.setPhone("592152152");

        PatientDto patientDto  = patientConverter.convertToDto(patient);

        assertNotNull(patientDto);
        assertEquals(patient.getName(), patientDto.getName());
        assertEquals(patient.getSurname(), patientDto.getSurname());
        assertEquals(patient.getBirthdate(), patientDto.getBirthdate());
        assertEquals(patient.getPhone(), patientDto.getPhone());
    }

    @Test
    void convertToEntity() {
        CreatePatientInputDto patientDto = new CreatePatientInputDto("Barbara", "Smyk", LocalDate.of(1990, 1, 1), "barbara.s@gmail.com", "592152152", "15-789, Białystok, ul. Pietkuna 19/10");

        Patient patient = patientConverter.convertToEntity(patientDto);
        assertEquals(patient.getName(), patientDto.getName());
        assertEquals(patient.getSurname(), patientDto.getSurname());
        assertEquals(patient.getBirthdate(), patientDto.getBirthdate());
        assertEquals(patient.getPhone(), patientDto.getPhone());
        assertEquals(patient.getEmail(), patientDto.getEmail());
        assertEquals(patient.getAddress(), patientDto.getAddress());

    }
}