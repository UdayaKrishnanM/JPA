//package com.example.service;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomerService {
//
//	
//	@Autowire
//	private CustomerRepository;
//	
//	public int saveCustomer(Customer customer) {
//		int customerId = 0;
//		//add code to save customer object to database
//		return customerId; //return saved objects customerId
//	}
//	
//	public List<Customer> findAllCustomers(){
//		//add code
//		return null;
//	}
//	
//	
//}

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.CustomerRepository;
import com.example.model.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    // Method to add a new customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    // Method to update an existing customer
    public Customer updateCustomer(int customerId, String newMobileNumber) {
    	Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setMobileNumber(newMobileNumber);
            return customerRepository.save(customer);
        } else {
            // Handle the case where the customer with the given ID is not found
            return null;
        }    }
    
    // Method to delete a customer by ID
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
    
    // Method to find all customers
    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
    
//    // Method to find a customer by ID
//    public Optional<Customer> findCustomerById(int customerId) {
//        return customerRepository.findById(customerId);
//    }
}