package pl.pingwit.dentalmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.dentalmanager.dto.DentalTreatmentDto;
import pl.pingwit.dentalmanager.service.DentalTreatmentService;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class DentalTreatmentController {
    private final DentalTreatmentService dentalTreatmentService;

    public DentalTreatmentController(DentalTreatmentService dentalTreatmentService) {
        this.dentalTreatmentService = dentalTreatmentService;
    }

    @GetMapping("/{id}")
    public DentalTreatmentDto findTreatmentById(@PathVariable(name = "id") Long id) {
        return dentalTreatmentService.findTreatmentById(id);
    }

    @GetMapping
    public List<DentalTreatmentDto> listTreatments() {
        return dentalTreatmentService.listTreatments();
    }

    @PostMapping
    public Long createTreatment(@RequestBody DentalTreatmentDto inputDto) {
        return dentalTreatmentService.createTreatment(inputDto);
    }
}
