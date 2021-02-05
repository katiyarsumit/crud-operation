package com.java.learning.service;

import java.util.List;
import java.util.Optional;

import com.java.learning.model.Employee;

public interface EmployeeService {
public Employee saveEmployee(Employee employee);
public List<Employee> getAllEmployee();
public Employee updateEmployee(int id);
public void deleteEmployee(int id);
public Optional<Employee> getEmployee(int id);
public Employee saveForm(Employee employee);

}
