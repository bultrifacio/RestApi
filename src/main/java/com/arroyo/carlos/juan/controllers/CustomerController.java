package com.arroyo.carlos.juan.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arroyo.carlos.juan.model.Customer;
import com.arroyo.carlos.juan.repository.CustomerRepository;
import com.arroyo.carlos.juan.repository.UserRepository;

@RestController
public class CustomerController {

	private CustomerRepository customerRepository;
	private Customer customer;
	private UserRepository userRepository;

	@Autowired
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public List<Customer> getCustomers() {
		return new ArrayList<>(customerRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerRepository.findById(id).get();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	public boolean createCustomer(@RequestBody Customer customer, Principal principal) {
		Long creatorUserId = userRepository.findUserByUsername(principal.getName()).getId();
		if (customerRepository.findById(customer.getId()) == null) {
			this.customer = new Customer(customer.getName(), customer.getSurname(), customer.getPhotoUrl(),
					creatorUserId, creatorUserId);
			customerRepository.save(this.customer);
			return true;
		}
		return false;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
	public boolean deleteCustomer(@PathVariable Long id) {
		if (customerRepository.findById(id) != null) {
			customerRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
	public boolean updateCustomer(@RequestBody Customer customer, @PathVariable Long id, Principal principal) {
		Long lastModificationUserId = userRepository.findUserByUsername(principal.getName()).getId();
		if (customerRepository.findById(id) != null) {
			this.customer = customerRepository.findById(id).get();
			if (customer.getName() != null && customer.getName() != this.customer.getName())
				this.customer.setName(customer.getName());
			if (customer.getSurname() != null && customer.getSurname() != this.customer.getSurname())
				this.customer.setSurname(customer.getSurname());
			if (customer.getPhotoUrl() != null && customer.getPhotoUrl() != this.customer.getPhotoUrl())
				this.customer.setPhotoUrl(customer.getPhotoUrl());
			this.customer.setLastModificationUserId(lastModificationUserId);
			customerRepository.save(this.customer);
			return true;
		}
		return false;
	}

}
