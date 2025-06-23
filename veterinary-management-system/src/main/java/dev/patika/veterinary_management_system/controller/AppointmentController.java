package dev.patika.veterinary_management_system.controller;

import dev.patika.veterinary_management_system.entity.Appointment;
import dev.patika.veterinary_management_system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Yeni randevu oluşturma (doktor müsaitlik ve çakışma kontrolleri servis içinde uygulanır)
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    // Randevu güncelleme
    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        appointment.setId(id);
        return appointmentService.updateAppointment(appointment);
    }

    // Randevu silme
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    // Id'ye göre randevu getirme
    @GetMapping("/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    // Tüm randevuları listeleme
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Doktor ve tarih aralığına göre randevuları filtreleme
    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorAndDateRange(
            @PathVariable Long doctorId,
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        LocalDateTime startDateTime = LocalDateTime.parse(start);
        LocalDateTime endDateTime = LocalDateTime.parse(end);
        return appointmentService.getAppointmentsByDoctorAndDateRange(doctorId, startDateTime, endDateTime);
    }

    // Hayvan ve tarih aralığına göre randevuları filtreleme
    @GetMapping("/animal/{animalId}")
    public List<Appointment> getAppointmentsByAnimalAndDateRange(
            @PathVariable Long animalId,
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        LocalDateTime startDateTime = LocalDateTime.parse(start);
        LocalDateTime endDateTime = LocalDateTime.parse(end);
        return appointmentService.getAppointmentsByAnimalAndDateRange(animalId, startDateTime, endDateTime);
    }
}

