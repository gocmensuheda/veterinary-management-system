package dev.patika.veterinary_management_system.repository;

import dev.patika.veterinary_management_system.entity.Appointment;
import dev.patika.veterinary_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Belirli doktor için, girilen tarih-saatte başka bir randevu olup olmadığını kontrol eder
    boolean existsByDoctorAndAppointmentDate(Doctor doctor, LocalDateTime appointmentDate);

    // Doktor ve tarih aralığına göre randevu filtreleme
    List<Appointment> findByDoctorIdAndAppointmentDateBetween(Long doctorId, LocalDateTime start, LocalDateTime end);

    // Hayvan ve tarih aralığına göre randevu filtreleme
    List<Appointment> findByAnimalIdAndAppointmentDateBetween(Long animalId, LocalDateTime start, LocalDateTime end);
}

