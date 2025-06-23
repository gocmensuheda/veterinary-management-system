package dev.patika.veterinary_management_system.repository;

import dev.patika.veterinary_management_system.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    // Aynı hayana ait, belirli tip (name & code) aşıları getirme
    List<Vaccine> findByAnimalIdAndNameAndCode(Long animalId, String name, String code);

    // Belirli hayvana ait tüm aşıların getirilmesi
    List<Vaccine> findByAnimalId(Long animalId);

    // Aşıların koruyuculuk bitiş tarihi belirli bir aralıkta olanlarını getirme
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate start, LocalDate end);
}
