package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeService service) {
        return (args) -> {
            // Save a few employees
            service.saveEmployee(new Employee("Suman", 120000, "Pune", "Consultant"));
            service.saveEmployee(new Employee("Ajay", 25000, "Bangalore", "Trainee"));
            service.saveEmployee(new Employee("Sree", 95000, "Chennai", "Manager"));
            service.saveEmployee(new Employee("Anjali", 80000, "Chennai", "Associate Consultant"));
            service.saveEmployee(new Employee("Smith", 90000, "Bangalore", "Manager"));

            // Find all employees whose names start with 'S'
            System.out.println(service.findEmployeeByNameLike("S"));

            // Find all employees having salary greater than or equal to 50,000
            System.out.println(service.findBySalaryGreaterThanEqual(50000));

            // Update base location to 'Mumbai' for the employee with ID 23
            System.out.println(service.updateBaseLocation(23, "Mumbai") + " record(s) updated");

            // Find employees in Bangalore, ordered by name
            System.out.println(service.findByBaseLocationOrderByEmpNameDesc("Bangalore"));

            // Find employees in Chennai with the designation 'Manager'
            System.out.println(service.findByBaseLocationAndDesignation("Chennai", "Manager"));

            // Find employees having salary between the given range
            System.out.println(service.findBySalaryBetween(25000, 90000));
        };
    }
}
