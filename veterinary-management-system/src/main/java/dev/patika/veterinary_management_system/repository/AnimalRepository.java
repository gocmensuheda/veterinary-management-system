package dev.patika.veterinary_management_system.repository;

import dev.patika.veterinary_management_system.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // Hayvan ismine göre filtreleme
    List<Animal> findByNameContainingIgnoreCase(String name);

    // Belirli müşteriye ait hayvanları getirme (Customer entity'sinde "owner" ilişkisinden yararlanılarak)
    List<Animal> findByOwnerId(Long ownerId);
}
