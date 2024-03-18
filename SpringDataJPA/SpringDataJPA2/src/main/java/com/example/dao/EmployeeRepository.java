package com.example.dao;

import com.example.entity.Employee;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
//	public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	    List<Employee> findByEmpNameContaining(String pattern);
//	}

    // Add query
	
	@Query("SELECT e FROM Employee e WHERE e.empName LIKE %:pattern%")
    List<Employee> findByNameLike(@Param("pattern") String pattern);
	
    // Add query using JPQL
    @Query("SELECT e FROM Employee e WHERE e.empSalary >= :salary")
    List<Employee> findBySalaryGreaterThanEqual(@Param("salary") double salary);
	
	@Modifying
	@Transactional
	//add query
	@Query("UPDATE Employee e SET e.baseLocation = :newBaseLocation WHERE e.empId = :empId")
    Integer updateBaseLocation(int empId, String newBaseLocation);	

	
	@Query("SELECT e FROM Employee e WHERE e.empSalary BETWEEN :lowerLimit AND :upperLimit")
    List<Employee> findBySalaryBetween(double lowerLimit, double upperLimit);
	
	List<Employee> findByBaseLocationOrderByEmpNameDesc(String baseLocation);
	
	List<Employee> findByBaseLocationAndDesignation(String baseLocation, String designation);
	
	

}
