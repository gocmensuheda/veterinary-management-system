package dev.patika.veterinary_management_system.service.impl;

import dev.patika.veterinary_management_system.entity.Appointment;
import dev.patika.veterinary_management_system.entity.Doctor;
import dev.patika.veterinary_management_system.exception.InvalidAppointmentException;
import dev.patika.veterinary_management_system.repository.AppointmentRepository;
import dev.patika.veterinary_management_system.repository.AvailableDateRepository;
import dev.patika.veterinary_management_system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AvailableDateRepository availableDateRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  AvailableDateRepository availableDateRepository) {
        this.appointmentRepository = appointmentRepository;
        this.availableDateRepository = availableDateRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        // Doktorun belirtilen tarihte çalışıp çalışmadığı (müsait günler) kontrolü
        Doctor doctor = appointment.getDoctor();
        LocalDate appointmentLocalDate = appointment.getAppointmentDate().toLocalDate();

        boolean isDoctorAvailable = availableDateRepository.existsByDoctorAndAvailableDate(doctor, appointmentLocalDate);
        if (!isDoctorAvailable) {
            throw new InvalidAppointmentException("Doktor bu tarihte çalışmıyor!");
        }

        // Aynı doktor için girilen tarih-saatte çakışan başka bir randevu var mı kontrolü
        boolean conflict = appointmentRepository.existsByDoctorAndAppointmentDate(doctor, appointment.getAppointmentDate());
        if (conflict) {
            throw new InvalidAppointmentException("Girilen saatte başka bir randevu mevcuttur!");
        }

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, start, end);
    }

    @Override
    public List<Appointment> getAppointmentsByAnimalAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByAnimalIdAndAppointmentDateBetween(animalId, start, end);
    }
}
