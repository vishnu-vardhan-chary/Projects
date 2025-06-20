package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.entity.Employee;
import com.ems.exception.UserNotFoundException;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Cacheable(value = "employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@Cacheable(value = "employees", key = "#name")
	public List<Employee> searchEmployeeByName(String name){
		return employeeRepository.findByNameLike(name+"%");
	}
	
	public List<Employee> searchEmployeeByAddress(String address){
		return employeeRepository.findByAddressLike(address+"%");
	}
	
	@Cacheable(value = "employees", key = "#salary")
	public List<Employee> searchEmployeeBySalary(Double salary){
		return employeeRepository.findBySalaryLessThan(salary);
	}
	
	@Cacheable(value = "employees", key = "#id")
	public Employee getEmployee(Long id){
		return employeeRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User Does Not Exists "+id));
	}
	
	@CacheEvict(value = "employees", allEntries = true)
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee saveEmployee(Employee emp){
		return employeeRepository.save(emp);
	}
	
	@CacheEvict(value = "employees", allEntries = true)
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee updateEmployee(Employee emp){
		return employeeRepository.save(emp);
	}
	
	@CacheEvict(value = "employees", allEntries = true)
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void deleteEmployee(Long id){
		employeeRepository.deleteById(id);
		
	}
}
