package pl.pingwit.dentalmanager.service;

import pl.pingwit.dentalmanager.dto.DentalTreatmentDto;

import java.util.List;

public interface DentalTreatmentService {
    DentalTreatmentDto findTreatmentById(Long id);

    List<DentalTreatmentDto> listTreatments();

    Long createTreatment(DentalTreatmentDto inputDto);
}
