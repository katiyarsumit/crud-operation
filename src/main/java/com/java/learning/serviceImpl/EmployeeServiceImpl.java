package com.java.learning.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.learning.dao.EmployeeDao;
import com.java.learning.model.Employee;
import com.java.learning.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee saveEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	public Employee updateEmployee(int id) {
		if (employeeDao.findById(id).isPresent()) {
			Employee e = employeeDao.findById(id).get();
			e.setName("vedant");
			return employeeDao.save(e);
		} else {
			return null;
		}
	}

	public void deleteEmployee(int id) {
		employeeDao.deleteById(id);
	}

	public Optional<Employee> getEmployee(int id) {
		if (employeeDao.findById(id).isPresent()) {
			return employeeDao.findById(id);
		} else {
			return null;
		}
	}

	public Employee saveForm(Employee employee) {
		return employeeDao.save(employee);
	}

}
