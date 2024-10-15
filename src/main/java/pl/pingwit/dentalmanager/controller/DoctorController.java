package pl.pingwit.dentalmanager.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.dentalmanager.dto.DoctorDto;
import pl.pingwit.dentalmanager.entity.Doctor;
import pl.pingwit.dentalmanager.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorDto> listDoctors() {
        return doctorService.listDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDto getDoctor(@PathVariable(name = "id")Long id) {
        return doctorService.getDoctor(id);
    }

    @PostMapping
    public Long createDoctor(@RequestBody DoctorDto inputDto) {
        return doctorService.createDoctor(inputDto);
    }

    @PutMapping("/{id}")
    public void updateDoctor(@RequestBody Doctor inputDto, @PathVariable(name = "id") Long id) {
        doctorService.updateDoctorRate(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable(name = "id") Long id) {
        doctorService.deleteDoctor(id);
    }
}