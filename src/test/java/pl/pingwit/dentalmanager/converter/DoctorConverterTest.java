package pl.pingwit.dentalmanager.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pingwit.dentalmanager.dto.DoctorDto;
import pl.pingwit.dentalmanager.entity.Doctor;

import static org.junit.jupiter.api.Assertions.*;

class DoctorConverterTest {
    private DoctorConverter doctorConverter;

    @BeforeEach
    void setUp() {
        doctorConverter = new DoctorConverter();
    }

    @Test
    void convertToDto() {
        Doctor doctor = new Doctor();
        doctor.setName("Marek");
        doctor.setSurname("Grzesiak");
        doctor.setSpecialty("Ortodonta");
        doctor.setPhone("496785777");
        doctor.setRate(5.0);

        DoctorDto doctorDto = doctorConverter.convertToDto(doctor);

        assertNotNull(doctorDto);
        assertEquals(doctor.getName(), doctorDto.getName());
        assertEquals(doctor.getSurname(), doctorDto.getSurname());
        assertEquals(doctor.getSpecialty(), doctorDto.getSpecialty());
        assertEquals(doctor.getPhone(), doctorDto.getPhone());
        assertEquals(doctor.getRate(), doctorDto.getRate());
    }

    @Test
    void convertToEntity() {
        DoctorDto doctorDto = new DoctorDto("Marek", "Grzesiak", "Ortodonta", "496785777", 5.0);

        Doctor doctor = doctorConverter.convertToEntity(doctorDto);
        assertEquals(doctorDto.getName(), doctor.getName());
        assertEquals(doctorDto.getSurname(), doctor.getSurname());
        assertEquals(doctorDto.getSpecialty(), doctor.getSpecialty());
        assertEquals(doctorDto.getPhone(), doctor.getPhone());
        assertEquals(doctorDto.getRate(), doctor.getRate());
    }
}