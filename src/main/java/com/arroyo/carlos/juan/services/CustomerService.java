package com.arroyo.carlos.juan.services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arroyo.carlos.juan.model.Customer;
import com.arroyo.carlos.juan.repositories.CustomerRepository;
import com.arroyo.carlos.juan.repositories.UserRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
    private UserRepository userRepository;
    private Customer customer;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    public List<Customer> getCustomers(){
        return new ArrayList<>(customerRepository.findAll());
    }

    public Customer getCustomer(Long id){
        return customerRepository.findOne(id);
    }

    public boolean createCustomer(Customer customer, Principal principal){
    	Long creatorId = userRepository.findUserByUsername(principal.getName()).getId();
    	if (customerRepository.findOne(customer.getId()) == null) {
    		customerRepository.save(new Customer(customer.getName(), customer.getSurname(), customer.getPhotoURL(), creatorId, creatorId));
			return true;
		}
		return false;
    }

    public boolean updateCustomer(Customer customer, Principal principal, Long id) {
    	Long lastModificationUserId = userRepository.findUserByUsername(principal.getName()).getId();
		if (customerRepository.findOne(id) != null) {
			this.customer = customerRepository.findOne(id);
			if (customer.getName() != null && customer.getName() != this.customer.getName())
				this.customer.setName(customer.getName());
			if (customer.getSurname() != null && customer.getSurname() != this.customer.getSurname())
				this.customer.setSurname(customer.getSurname());
			if (customer.getPhotoURL() != null && customer.getPhotoURL() != this.customer.getPhotoURL())
				this.customer.setPhotoURL(customer.getPhotoURL());
			this.customer.setLastModificationUserId(lastModificationUserId);
			customerRepository.save(this.customer);
			return true;
		}
		return false;
    }

    public boolean deleteCustomer(Long id) {
    	if (customerRepository.findOne(id) != null) {
			customerRepository.delete(id);
			return true;
		}
		return false;
    }

}
