package com.java.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.learning.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
