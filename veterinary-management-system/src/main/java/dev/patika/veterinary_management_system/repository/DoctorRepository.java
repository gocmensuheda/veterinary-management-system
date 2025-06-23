package dev.patika.veterinary_management_system.repository;

import dev.patika.veterinary_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Doktor ismine göre filtreleme
    List<Doctor> findByNameContainingIgnoreCase(String name);
}

