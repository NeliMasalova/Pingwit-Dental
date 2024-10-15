package pl.pingwit.dentalmanager.service;

import pl.pingwit.dentalmanager.dto.AppointmentDto;
import pl.pingwit.dentalmanager.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentDto getAppointmentByPatientId(Long patientId);

//    Long createAppointment(AppointmentDto inputDto);

    void deleteAppointment(Long id);

    List<AppointmentDto> listAppointments();

    Appointment createAppointmentWithPayment(AppointmentDto appointmentDTO);
}
