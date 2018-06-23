package com.arroyo.carlos.juan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arroyo.carlos.juan.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
