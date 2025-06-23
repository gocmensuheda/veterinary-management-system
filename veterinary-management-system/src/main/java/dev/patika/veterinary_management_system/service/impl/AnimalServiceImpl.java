package dev.patika.veterinary_management_system.service.impl;

import dev.patika.veterinary_management_system.entity.Animal;
import dev.patika.veterinary_management_system.repository.AnimalRepository;
import dev.patika.veterinary_management_system.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl extends AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }

    @Override
    public Optional<Animal> getAnimalById(Long animalId) {
        return animalRepository.findById(animalId);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> getAnimalsByName(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Animal> getAnimalsByCustomerId(Long customerId) {
        return animalRepository.findByOwnerId(customerId);
    }
}
