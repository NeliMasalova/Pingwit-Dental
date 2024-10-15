package pl.pingwit.dentalmanager.service;

import pl.pingwit.dentalmanager.dto.DoctorDto;
import pl.pingwit.dentalmanager.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> listDoctors();

    Long createDoctor(DoctorDto inputDto);

    DoctorDto getDoctor(Long id);

    void deleteDoctor(Long id);

    void updateDoctorRate(Long id, Doctor inputDto);
}
