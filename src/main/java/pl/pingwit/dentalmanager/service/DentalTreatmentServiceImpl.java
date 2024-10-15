package pl.pingwit.dentalmanager.service;

import org.springframework.stereotype.Service;
import pl.pingwit.dentalmanager.converter.DentalTreatmentConverter;
import pl.pingwit.dentalmanager.dto.DentalTreatmentDto;
import pl.pingwit.dentalmanager.entity.DentalTreatment;
import pl.pingwit.dentalmanager.exceptionhandling.NotFoundException;
import pl.pingwit.dentalmanager.repository.DentalTreatmentRepository;

import java.util.List;

@Service
public class DentalTreatmentServiceImpl implements DentalTreatmentService {
    private final DentalTreatmentConverter dentalTreatmentConverter;
    private final DentalTreatmentRepository dentalTreatmentRepository;

    public DentalTreatmentServiceImpl(DentalTreatmentConverter dentalTreatmentConverter, DentalTreatmentRepository dentalTreatmentRepository) {
        this.dentalTreatmentConverter = dentalTreatmentConverter;
        this.dentalTreatmentRepository = dentalTreatmentRepository;
    }

    @Override
    public DentalTreatmentDto findTreatmentById(Long id) {
        DentalTreatment dentalTreatment = dentalTreatmentRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Treatment with such id not found! Please, try again."));
        return dentalTreatmentConverter.convertToDto(dentalTreatment);
    }

    @Override
    public List<DentalTreatmentDto> listTreatments() {
        return dentalTreatmentRepository.findAll().stream()
                .map(dentalTreatmentConverter::convertToDto)
                .toList();
    }

    @Override
    public Long createTreatment(DentalTreatmentDto inputDto) {
        DentalTreatment saveDentalTreatment = dentalTreatmentRepository.save(dentalTreatmentConverter.convertToEntity(inputDto));
        return saveDentalTreatment.getId();
    }
}
