package dev.patika.veterinary_management_system.service;

import dev.patika.veterinary_management_system.entity.Vaccine;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VaccineService {
    Vaccine saveVaccine(Vaccine vaccine);
    Vaccine updateVaccine(Vaccine vaccine);
    void deleteVaccine(Long vaccineId);
    Optional<Vaccine> getVaccineById(Long vaccineId);
    List<Vaccine> getAllVaccines();
    List<Vaccine> getVaccinesByAnimalId(Long animalId);
    List<Vaccine> getVaccinesByProtectionFinishDateBetween(LocalDate start, LocalDate end);
}

