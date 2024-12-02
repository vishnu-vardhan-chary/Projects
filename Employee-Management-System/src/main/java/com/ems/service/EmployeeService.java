package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public List<Employee> searchEmployeeByName(String name){
		return employeeRepository.findByNameLike(name+"%");
	}
	
	public List<Employee> searchEmployeeByAddress(String address){
		return employeeRepository.findByAddressLike(address+"%");
	}
	
	public List<Employee> searchEmployeeBySalary(Double salary){
		return employeeRepository.findBySalaryLessThan(salary);
	}
	
	public Employee getEmployee(Long id){
		return employeeRepository.findById(id).get();
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee saveEmployee(Employee emp){
		return employeeRepository.save(emp);
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee updateEmployee(Employee emp){
		return employeeRepository.save(emp);
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void deleteEmployee(Long id){
		employeeRepository.deleteById(id);
	}
}
