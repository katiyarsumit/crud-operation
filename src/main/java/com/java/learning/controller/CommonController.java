package com.java.learning.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.java.learning.model.Employee;
import com.java.learning.service.EmployeeService;

@RestController
public class CommonController {
	
	@Autowired
	private EmployeeService employeeService;

@GetMapping(value="/welcome")
public Employee welcome() {
	System.out.println("you are most welcome");
	Employee e=new Employee(01,"sumit","sumit@gmail.com","7204203158");
return e;
}

@PostMapping(value="/save-employee")
public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.OK);
}

@GetMapping(value="/get-employee/{id}")
public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable (value="id") int id){
	
	return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
	
}

@GetMapping(value="/all-employee")
public ResponseEntity<List<Employee>> getAllEmployee(HttpServletRequest request){
	String header=request.getHeader("Authorization");
	String token=header.replace("Bearer","");
	System.out.println("@@@@@@@@@@" +token);
	return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
}

@PutMapping(value="/update-employee/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable (value="id") int id) {
	return new ResponseEntity<>(employeeService.updateEmployee(id),HttpStatus.OK);
}

@DeleteMapping(value="/delete-employee/{id}")
public ResponseEntity<Status> deleteEmployee(@PathVariable (value="id") int id){
	employeeService.deleteEmployee(id);
	return new ResponseEntity<>(HttpStatus.OK);
}

@PostMapping(value="/save-form")
public ResponseEntity<Employee> saveForm(Employee employee){
	return new ResponseEntity<>(employeeService.saveForm(employee),HttpStatus.OK);
}

@GetMapping(value="/exception-handler")
public void throwException() throws FileNotFoundException {
	throw new FileNotFoundException();
}

}

