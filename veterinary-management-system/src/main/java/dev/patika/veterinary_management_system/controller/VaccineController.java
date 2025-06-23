package dev.patika.veterinary_management_system.controller;

import dev.patika.veterinary_management_system.entity.Vaccine;
import dev.patika.veterinary_management_system.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;

    @Autowired
    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    // Yeni aşı oluşturma
    @PostMapping
    public Vaccine createVaccine(@RequestBody Vaccine vaccine) {
        return vaccineService.saveVaccine(vaccine);
    }

    // Aşı güncelleme
    @PutMapping("/{id}")
    public Vaccine updateVaccine(@PathVariable Long id, @RequestBody Vaccine vaccine) {
        vaccine.setId(id);
        return vaccineService.updateVaccine(vaccine);
    }

    // Aşı silme
    @DeleteMapping("/{id}")
    public void deleteVaccine(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
    }

    // Id'ye göre aşı getirme
    @GetMapping("/{id}")
    public Optional<Vaccine> getVaccineById(@PathVariable Long id) {
        return vaccineService.getVaccineById(id);
    }

    // Tüm aşıları getirme
    @GetMapping
    public List<Vaccine> getAllVaccines() {
        return vaccineService.getAllVaccines();
    }

    // Belirli hayvana ait aşıları listeleme
    @GetMapping("/animal/{animalId}")
    public List<Vaccine> getVaccinesByAnimal(@PathVariable Long animalId) {
        return vaccineService.getVaccinesByAnimalId(animalId);
    }

    // Koruyuculuk bitiş tarihi belirtilen aralıkta olan aşıları listeleme
    @GetMapping("/protection")
    public List<Vaccine> getVaccinesByProtectionFinishDate(
            @RequestParam("start") String startDate,
            @RequestParam("end") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return vaccineService.getVaccinesByProtectionFinishDateBetween(start, end);
    }
}

