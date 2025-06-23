package dev.patika.veterinary_management_system.repository;

import dev.patika.veterinary_management_system.entity.AvailableDate;
import dev.patika.veterinary_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    // Belirli doktora ait müsait günleri getirme
    List<AvailableDate> findByDoctorId(Long doctorId);

    // Doktorun belirtilen tarihte müsait olup olmadığını kontrol eden metod
    boolean existsByDoctorAndAvailableDate(Doctor doctor, LocalDate availableDate);
}

