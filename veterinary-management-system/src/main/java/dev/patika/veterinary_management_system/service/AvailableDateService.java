package dev.patika.veterinary_management_system.service;

import dev.patika.veterinary_management_system.entity.AvailableDate;
import java.util.List;
import java.util.Optional;

public interface AvailableDateService {
    AvailableDate saveAvailableDate(AvailableDate availableDate);
    AvailableDate updateAvailableDate(AvailableDate availableDate);
    void deleteAvailableDate(Long availableDateId);
    Optional<AvailableDate> getAvailableDateById(Long availableDateId);
    List<AvailableDate> getAllAvailableDates();
    List<AvailableDate> getAvailableDatesByDoctorId(Long doctorId);
}
