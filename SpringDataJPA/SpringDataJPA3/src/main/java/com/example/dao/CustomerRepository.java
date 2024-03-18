package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

		//add query to fetch customer details by city
		@Query("SELECT c FROM Customer c WHERE c.address.city = :city")
		List<Customer> findByCity(String city);
	
}
