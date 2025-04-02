package com.carlosj09.customers.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    List<Customer> findAll() {
        return customers;
    }

    Optional<Customer> findById(Long id) {
        return customers.stream()
                .filter(customer -> customer.id().equals(id))
                .findFirst();
    }

    Customer create(Customer customer) {
        customers.add(customer);

        return customer;
    }

    Customer update(Long id, Customer customer) {
        return customer;
    }

    void delete(Long id) {

    }
}
