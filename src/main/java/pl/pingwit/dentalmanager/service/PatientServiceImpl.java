package pl.pingwit.dentalmanager.service;

import org.springframework.stereotype.Service;
import pl.pingwit.dentalmanager.converter.PatientConverter;
import pl.pingwit.dentalmanager.dto.CreatePatientInputDto;
import pl.pingwit.dentalmanager.dto.PatientDto;
import pl.pingwit.dentalmanager.entity.Patient;
import pl.pingwit.dentalmanager.dto.PatientShortDto;
import pl.pingwit.dentalmanager.exceptionhandling.NotFoundException;
import pl.pingwit.dentalmanager.repository.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientConverter patientConverter;

    public PatientServiceImpl(PatientRepository patientRepository, PatientConverter patientConverter) {
        this.patientRepository = patientRepository;
        this.patientConverter = patientConverter;
    }

    @Override
    public List<PatientShortDto> listPatients() {
        return patientRepository.findAll().stream()
                .map(patientConverter::convertToShortDto)
                .toList();
    }

    @Override
    public Long createPatient(CreatePatientInputDto inputDto) {
        Patient savedPatient = patientRepository.save(patientConverter.convertToEntity(inputDto));
        return savedPatient.getId();
    }

    @Override
    public PatientDto getPatient(Long id) {
        Patient patient = patientRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Patient with such id not found! Please, try again."));
        return patientConverter.convertToDto(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void updatePatient(Long id, Patient inputDto) {
        Patient patient = patientRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Patient with such id not found! Please, try again."));

        if (inputDto.getName() != null) {
            patient.setName(inputDto.getName());
        }
        if (inputDto.getSurname() != null) {
            patient.setSurname(inputDto.getSurname());
        }
        if (inputDto.getBirthdate() != null) {
            patient.setBirthdate(inputDto.getBirthdate());
        }
        if (inputDto.getPhone() != null) {
            patient.setPhone(inputDto.getPhone());
        }
        if (inputDto.getAddress() != null) {
            patient.setAddress(inputDto.getAddress());
        }
        if (inputDto.getEmail() != null) {
            patient.setEmail(inputDto.getEmail());
        }
        patientRepository.save(patient);
    }
}
