package pl.pingwit.dentalmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Find treatment by ID", description = "Returns a DentalTreatmentDto object based on ID")
    @GetMapping("/{id}")
    public DentalTreatmentDto findTreatmentById(@PathVariable(name = "id") Long id) {
        return dentalTreatmentService.findTreatmentById(id);
    }

    @Operation(summary = "Find all treatments", description = "Returns a list of DentalTreatmentDto objects")
    @GetMapping
    public List<DentalTreatmentDto> listTreatments() {
        return dentalTreatmentService.listTreatments();
    }

    @Operation(summary = "Create treatment", description = "Returns a new DentalTreatmentDto object")
    @PostMapping
    public Long createTreatment(@RequestBody DentalTreatmentDto inputDto) {
        return dentalTreatmentService.createTreatment(inputDto);
    }
}
