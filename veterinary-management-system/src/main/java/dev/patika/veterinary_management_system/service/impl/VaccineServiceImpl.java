package dev.patika.veterinary_management_system.service.impl;
package dev.patika.veterinary_management_system.service.impl;

import dev.patika.veterinary_management_system.entity.Vaccine;
import dev.patika.veterinary_management_system.exception.DuplicateVaccineException;
import dev.patika.veterinary_management_system.repository.VaccineRepository;
import dev.patika.veterinary_management_system.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl extends VaccineService {

    private final VaccineRepository vaccineRepository;

    @Autowired
    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public Vaccine saveVaccine(Vaccine vaccine) {
        // Aynı hayana ait aynı tip (name & code) aşının koruyuculuk süresi henüz bitmemişse kayıt oluşturulamaz.
        LocalDate today = LocalDate.now();
        List<Vaccine> existingVaccines = vaccineRepository.findByAnimalIdAndNameAndCode(
                vaccine.getAnimal().getId(),
                vaccine.getName(),
                vaccine.getCode()
        );

        boolean duplicateExists = existingVaccines.stream()
                .anyMatch(v -> v.getProtectionFinishDate() != null && v.getProtectionFinishDate().isAfter(today));

        if (duplicateExists) {
            throw new DuplicateVaccineException("Aşının koruyuculuk süresi bitmemiş aynı tip aşı zaten mevcut!");
        }

        return vaccineRepository.save(vaccine);
    }

    @Override
    public Vaccine updateVaccine(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    @Override
    public void deleteVaccine(Long vaccineId) {
        vaccineRepository.deleteById(vaccineId);
    }

    @Override
    public Optional<Vaccine> getVaccineById(Long vaccineId) {
        return vaccineRepository.findById(vaccineId);
    }

    @Override
    public List<Vaccine> getAllVaccines() {
        return vaccineRepository.findAll();
    }

    @Override
    public List<Vaccine> getVaccinesByAnimalId(Long animalId) {
        return vaccineRepository.findByAnimalId(animalId);
    }

    @Override
    public List<Vaccine> getVaccinesByProtectionFinishDateBetween(LocalDate start, LocalDate end) {
        return vaccineRepository.findByProtectionFinishDateBetween(start, end);
    }
}

