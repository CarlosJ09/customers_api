package com.carlosj09.customers.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import jakarta.validation.constraints.NotEmpty;

public record Customer(
        @Id Long id,
        @NotEmpty String name,
        @NotEmpty String email,
        @NotEmpty String phone,
        @Column("address_id") Long addressId) {
}
