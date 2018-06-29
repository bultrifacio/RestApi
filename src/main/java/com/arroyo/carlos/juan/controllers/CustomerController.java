package com.arroyo.carlos.juan.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arroyo.carlos.juan.model.Customer;
import com.arroyo.carlos.juan.services.CustomerService;

@RestController
public class CustomerController {
	
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	public void createCustomer(@RequestBody Customer customer, Principal principal) {
		customerService.createCustomer(customer, principal);
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/customers/{id}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable Long id, Principal principal) {
		customerService.updateCustomer(customer, principal, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}
}
