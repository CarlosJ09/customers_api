package com.carlosj09.customers.customer;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.carlosj09.customers.address.AddressRepository;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerController(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("")
    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Customer> getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
        if (customer.addressId() != null && !addressRepository.existsById(customer.addressId())) {
            return ResponseEntity.badRequest()
                    .body("Cannot create customer: Address with ID " + customer.addressId() + " does not exist");
        }

        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        if (customer.addressId() != null && !addressRepository.existsById(customer.addressId())) {
            return ResponseEntity.badRequest()
                    .body("Cannot update customer: Address with ID " + customer.addressId() + " does not exist");
        }

        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}