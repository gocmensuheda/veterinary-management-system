package dev.patika.veterinary_management_system.service.impl;

import dev.patika.veterinary_management_system.entity.AvailableDate;
import dev.patika.veterinary_management_system.repository.AvailableDateRepository;
import dev.patika.veterinary_management_system.service.AvailableDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AvailableDateServiceImpl implements AvailableDateService {

    private final AvailableDateRepository availableDateRepository;

    @Autowired
    public AvailableDateServiceImpl(AvailableDateRepository availableDateRepository) {
        this.availableDateRepository = availableDateRepository;
    }

    @Override
    public AvailableDate saveAvailableDate(AvailableDate availableDate) {
        return availableDateRepository.save(availableDate);
    }

    @Override
    public AvailableDate updateAvailableDate(AvailableDate availableDate) {
        return availableDateRepository.save(availableDate);
    }

    @Override
    public void deleteAvailableDate(Long availableDateId) {
        availableDateRepository.deleteById(availableDateId);
    }

    @Override
    public Optional<AvailableDate> getAvailableDateById(Long availableDateId) {
        return availableDateRepository.findById(availableDateId);
    }

    @Override
    public List<AvailableDate> getAllAvailableDates() {
        return availableDateRepository.findAll();
    }

    @Override
    public List<AvailableDate> getAvailableDatesByDoctorId(Long doctorId) {
        return availableDateRepository.findByDoctorId(doctorId);
    }
}

