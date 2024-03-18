package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.entity.Address;
import com.example.entity.Customer;
import com.example.service.CustomerService;

@SpringBootApplication
@ComponentScan("com.example")
public class SpringDataJpaOnetoOneMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaOnetoOneMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerService service) {
        return (args) -> {
            // customer objects
            Customer customer1 = new Customer("Padma");
            Customer customer2 = new Customer("Vijay");

            // address objects
            Address address1 = new Address("MG Road", "Bangalore");
            Address address2 = new Address("FC Road", "Pune");

            service.saveCustomer(customer1, address1);
            service.saveCustomer(customer2, address2);

            // get all customers
            System.out.println(service.getAllCustomers());

            // get all customers from given city
            System.out.println(service.getAllCustomersFromCity("Pune"));
        };
    }
}
