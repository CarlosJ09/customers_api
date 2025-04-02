package com.carlosj09.customers.customer;

import com.carlosj09.customers.address.Address;
import jakarta.validation.constraints.NotEmpty;

public record Customer(
        Long id,
        @NotEmpty
        String name,
        @NotEmpty
        String email,
        @NotEmpty
        String phone,
        Address address
) {
}
