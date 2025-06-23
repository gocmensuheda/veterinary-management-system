package dev.patika.veterinary_management_system.service;

import dev.patika.veterinary_management_system.entity.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctor(Long doctorId);
    Optional<Doctor> getDoctorById(Long doctorId);
    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorsByName(String name);
}

