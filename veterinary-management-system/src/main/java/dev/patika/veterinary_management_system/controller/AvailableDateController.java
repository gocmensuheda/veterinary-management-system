package dev.patika.veterinary_management_system.controller;

import dev.patika.veterinary_management_system.entity.AvailableDate;
import dev.patika.veterinary_management_system.service.AvailableDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/available-dates")
public class AvailableDateController {

    private final AvailableDateService availableDateService;

    @Autowired
    public AvailableDateController(AvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    // Yeni müsait gün oluşturma
    @PostMapping
    public AvailableDate createAvailableDate(@RequestBody AvailableDate availableDate) {
        return availableDateService.saveAvailableDate(availableDate);
    }

    // Müsait gün güncelleme
    @PutMapping("/{id}")
    public AvailableDate updateAvailableDate(@PathVariable Long id, @RequestBody AvailableDate availableDate) {
        availableDate.setId(id);
        return availableDateService.updateAvailableDate(availableDate);
    }

    // Müsait gün silme
    @DeleteMapping("/{id}")
    public void deleteAvailableDate(@PathVariable Long id) {
        availableDateService.deleteAvailableDate(id);
    }

    // Id'ye göre müsait gün getirme
    @GetMapping("/{id}")
    public Optional<AvailableDate> getAvailableDateById(@PathVariable Long id) {
        return availableDateService.getAvailableDateById(id);
    }

    // Tüm müsait günleri listeleme
    @GetMapping
    public List<AvailableDate> getAllAvailableDates() {
        return availableDateService.getAllAvailableDates();
    }

    // Belirli doktora ait müsait günleri listeleme
    @GetMapping("/doctor/{doctorId}")
    public List<AvailableDate> getAvailableDatesByDoctor(@PathVariable Long doctorId) {
        return availableDateService.getAvailableDatesByDoctorId(doctorId);
    }
}

