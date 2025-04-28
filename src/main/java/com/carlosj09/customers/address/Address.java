package com.carlosj09.customers.address;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;

public record Address(
                @Id Long id,
                @NotEmpty String street,
                @NotEmpty String city,
                @NotEmpty String state,
                @NotEmpty String zip) {
}
