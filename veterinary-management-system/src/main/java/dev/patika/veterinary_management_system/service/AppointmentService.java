package dev.patika.veterinary_management_system.service;

import dev.patika.veterinary_management_system.entity.Appointment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Long appointmentId);
    Optional<Appointment> getAppointmentById(Long appointmentId);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByDoctorAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end);
    List<Appointment> getAppointmentsByAnimalAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end);
}
