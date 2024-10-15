package pl.pingwit.dentalmanager.service;

import pl.pingwit.dentalmanager.dto.CreatePatientInputDto;
import pl.pingwit.dentalmanager.dto.PatientDto;
import pl.pingwit.dentalmanager.dto.PatientShortDto;
import pl.pingwit.dentalmanager.entity.Patient;

import java.util.List;

public interface PatientService {
    List<PatientShortDto> listPatients();

    Long createPatient(CreatePatientInputDto inputDto);

    PatientDto getPatient(Long id);

    void deletePatient(Long id);

    void updatePatient(Long id, Patient inputDto);
}
