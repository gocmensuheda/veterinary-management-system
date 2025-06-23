package dev.patika.veterinary_management_system.service;

import dev.patika.veterinary_management_system.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    Optional<Customer> getCustomerById(Long customerId);
    List<Customer> getAllCustomers();
    List<Customer> getCustomersByName(String name); // İsim filtreleme
}

