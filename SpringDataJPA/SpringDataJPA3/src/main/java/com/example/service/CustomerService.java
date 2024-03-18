package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.CustomerRepository;
import com.example.dao.AddressRepository;
import com.example.entity.Customer;
import com.example.entity.Address;

import java.util.List;

@Service
public class CustomerService {

    @Autowired 
    private CustomerRepository customerRepo;

    @Autowired 
    private AddressRepository addressRepo;

    public void saveCustomer(Customer customer, Address address) {
        // Note: first save the object in parent table and then into child table

        // Add code to save address object
        addressRepo.save(address);

        // Add code to set address of customer object by above saved address object
        customer.setAddress(address);

        // Add code to save customer object
        customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        //Add code to modify this return value
        return customerRepo.findAll();
    }

    public List<Customer> getAllCustomersFromCity(String city) {
       //Add code to modify this return value
       return customerRepo.findByCity(city);
   }
}

