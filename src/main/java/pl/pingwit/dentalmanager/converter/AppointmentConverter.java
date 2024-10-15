package pl.pingwit.dentalmanager.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.dentalmanager.dto.AppointmentDto;
import pl.pingwit.dentalmanager.entity.Appointment;
import pl.pingwit.dentalmanager.entity.DentalTreatment;
import pl.pingwit.dentalmanager.entity.Doctor;
import pl.pingwit.dentalmanager.entity.Patient;
import pl.pingwit.dentalmanager.exceptionhandling.NotFoundException;
import pl.pingwit.dentalmanager.repository.DentalTreatmentRepository;
import pl.pingwit.dentalmanager.repository.DoctorRepository;
import pl.pingwit.dentalmanager.repository.PatientRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AppointmentConverter {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final DentalTreatmentRepository dentalTreatmentRepository;

    public AppointmentConverter(PatientRepository patientRepository, DoctorRepository doctorRepository, DentalTreatmentRepository dentalTreatmentRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.dentalTreatmentRepository = dentalTreatmentRepository;
    }

    public AppointmentDto mapToDto(Appointment appointment) {
        AppointmentDto dto = new AppointmentDto();
        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setAppointmentStatus(appointment.getAppointmentStatus());
        dto.setPatient(appointment.getPatient());
        dto.setDoctor(appointment.getDoctor());
        dto.setDentalTreatment(appointment.getDentalTreatments());

        return dto;
    }

    public Appointment mapToEntity(AppointmentDto inputDto) {
        Appointment appointment = new Appointment();
        appointment.setDate(inputDto.getDate());
        appointment.setAppointmentStatus(inputDto.getAppointmentStatus());

        Patient patient = patientRepository.findById(inputDto.getPatient().getId()).
                orElseThrow(()-> new NotFoundException("Patient with such id doesn't found. Please, try again."));
        Doctor doctor = doctorRepository.findById(inputDto.getDoctor().getId()).
                orElseThrow(()-> new NotFoundException("Doctor with such id doesn't found. Please, try again."));
        Set<DentalTreatment> dentalTreatments = inputDto.getDentalTreatment().stream()
                .map(treatmentDto -> dentalTreatmentRepository.findById(treatmentDto.getId()).orElseThrow())
                .collect(Collectors.toSet());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDentalTreatments(dentalTreatments);

        return appointment;
    }
}