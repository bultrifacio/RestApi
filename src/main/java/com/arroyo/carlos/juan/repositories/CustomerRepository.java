package com.arroyo.carlos.juan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arroyo.carlos.juan.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
