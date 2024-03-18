package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.entity.Employee;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public int saveEmployee(Employee emp) {
	    return employeeRepository.save(emp).getEmpId();
	}


	
	public List<Employee> findEmployeeByNameLike(String pattern){
		//fill the code
	    return employeeRepository.findByNameLike(pattern);

	}
	
	public List<Employee> findBySalaryGreaterThanEqual(double salary){
	    return employeeRepository.findBySalaryGreaterThanEqual(salary);
	}

	
	
	public Integer updateBaseLocation(int empId, String newBaseLocation) {
	    return employeeRepository.updateBaseLocation(empId, newBaseLocation);
	}

	public List<Employee> findBySalaryBetween(double lowerLimit, double upperLimit){
	    return employeeRepository.findBySalaryBetween(lowerLimit, upperLimit);
	}

	
	public List<Employee> findByBaseLocationOrderByEmpNameDesc(String baseLocation){
	    return employeeRepository.findByBaseLocationOrderByEmpNameDesc(baseLocation);
	}

	
	public List<Employee> findByBaseLocationAndDesignation(String baseLocation, String designation){
	    return employeeRepository.findByBaseLocationAndDesignation(baseLocation, designation);
	}


	
	
	
	
}
