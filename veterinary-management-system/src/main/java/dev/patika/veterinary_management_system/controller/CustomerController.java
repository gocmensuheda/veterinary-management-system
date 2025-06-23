package dev.patika.veterinary_management_system.controller;

import dev.patika.veterinary_management_system.entity.Customer;
import dev.patika.veterinary_management_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    // Yeni müşteri oluşturma
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    // Müşteri güncelleme
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customer.setId(id);
        return customerService.updateCustomer(customer);
    }

    // Müşteri silme
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

    // Id'ye göre müşteri getirme
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    // Tüm müşterileri listeleme
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    // İsim filtresi ile müşteri arama
    @GetMapping("/search")
    public List<Customer> searchCustomersByName(@RequestParam String name){
        return customerService.getCustomersByName(name);
    }
}
