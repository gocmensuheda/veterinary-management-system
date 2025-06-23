package dev.patika.veterinary_management_system.repository;

import dev.patika.veterinary_management_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // İsim bazında filtreleme (küçük-büyük harf duyarsız)
    List<Customer> findByNameContainingIgnoreCase(String name);
}

