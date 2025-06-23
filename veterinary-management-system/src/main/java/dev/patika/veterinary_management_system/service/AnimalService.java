package dev.patika.veterinary_management_system.service;

import dev.patika.veterinary_management_system.entity.Animal;
import java.util.List;
import java.util.Optional;

public interface AnimalService {
    Animal saveAnimal(Animal animal);
    Animal updateAnimal(Animal animal);
    void deleteAnimal(Long animalId);
    Optional<Animal> getAnimalById(Long animalId);
    List<Animal> getAllAnimals();
    List<Animal> getAnimalsByName(String name); // İsim filtreleme
    List<Animal> getAnimalsByCustomerId(Long customerId); // Sahip bazında filtreleme
}

