package dev.patika.veterinary_management_system.controller;

import dev.patika.veterinary_management_system.entity.Animal;
import dev.patika.veterinary_management_system.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    // Yeni hayvan oluşturma
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal){
        return animalService.saveAnimal(animal);
    }

    // Hayvan güncelleme
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal){
        animal.setId(id);
        return animalService.updateAnimal(animal);
    }

    // Hayvan silme
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimal(id);
    }

    // Id'ye göre hayvan getirme
    @GetMapping("/{id}")
    public Optional<Animal> getAnimalById(@PathVariable Long id){
        return animalService.getAnimalById(id);
    }

    // Tüm hayvanları listeleme
    @GetMapping
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    // Hayvan ismine göre arama
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name){
        return animalService.getAnimalsByName(name);
    }

    // Belirli bir müşteriye ait hayvanları listeleme
    @GetMapping("/customer/{customerId}")
    public List<Animal> getAnimalsByCustomer(@PathVariable Long customerId) {
        return animalService.getAnimalsByCustomerId(customerId);
    }
}

