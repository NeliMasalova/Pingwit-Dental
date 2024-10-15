package pl.pingwit.dentalmanager.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.dentalmanager.dto.CreatePatientInputDto;
import pl.pingwit.dentalmanager.dto.PatientDto;
import pl.pingwit.dentalmanager.dto.PatientShortDto;
import pl.pingwit.dentalmanager.entity.Patient;
import pl.pingwit.dentalmanager.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientShortDto> listPatients() {
        return patientService.listPatients();
    }

    @GetMapping("/{id}")
    public PatientDto getPatient(@PathVariable(name = "id") Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping
    public Long createPatient(@RequestBody CreatePatientInputDto inputDto) {
        return patientService.createPatient(inputDto);
    }

    @PutMapping("/{id}")
    public void updatePatient(@RequestBody Patient inputDto, @PathVariable(name = "id") Long id) {
        patientService.updatePatient(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable(name = "id") Long id) {
        patientService.deletePatient(id);
    }
}