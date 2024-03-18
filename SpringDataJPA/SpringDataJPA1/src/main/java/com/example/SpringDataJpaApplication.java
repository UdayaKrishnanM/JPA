package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Customer;
import com.example.service.CustomerService;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean 
	public CommandLineRunner demo(CustomerService service) {
		return (args)->{
			
			service.saveCustomer(new Customer("Udaya", "648738", "Chennai"));
			service.saveCustomer(new Customer("Vignesh", "728324", "Trichy"));
			service.saveCustomer(new Customer("Sagar", "762582", "Bangalore"));
			service.saveCustomer(new Customer("Unknown", "234567", "Unknown"));
			
			
			System.out.println("Updated Customer:");
			System.out.println(service.updateCustomer(3,"7762214"));

			
			System.out.println(service.findAllCustomers());
			
			service.deleteCustomer(4);
			
		};
	}
	
}
