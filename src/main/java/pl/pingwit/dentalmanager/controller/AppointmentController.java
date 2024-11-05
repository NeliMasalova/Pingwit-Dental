package pl.pingwit.dentalmanager.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.dentalmanager.dto.AppointmentDto;
import pl.pingwit.dentalmanager.entity.Appointment;
import pl.pingwit.dentalmanager.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<AppointmentDto> listAppointments() {
        return appointmentService.listAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDto getAppointmentByPatientId(@PathVariable(name = "id") Long patientId) {
        return appointmentService.getAppointmentByPatientId(patientId);
    }

    @PostMapping("/with-payment")
    public Appointment createAppointmentWithPayment(@RequestBody AppointmentDto appointmentDTO) {
        return appointmentService.createAppointmentWithPayment(appointmentDTO);
    }

    @DeleteMapping
    public void deleteAppointment(@PathVariable(name = "id") Long id) {
        appointmentService.deleteAppointment(id);
    }
}