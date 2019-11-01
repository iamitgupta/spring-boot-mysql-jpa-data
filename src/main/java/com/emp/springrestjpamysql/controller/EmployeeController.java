package com.emp.springrestjpamysql.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.springrestjpamysql.beans.Employee;
import com.emp.springrestjpamysql.repo.EmployeeRepo;

@RestController
@RequestMapping("/rest/emp")
public class EmployeeController {

	@Autowired
	EmployeeRepo repository;

	@GetMapping("/all")
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{name}")
	public List<Employee> getUser(@PathVariable("name") final String name) {
		return repository.findByName(name);

	}

	@GetMapping("/id/{id}")
	public Optional<Employee> getId(@PathVariable("id") final Integer id) {
		return repository.findById(id);
	}

	@PostMapping("/create")
	public Employee createEmp(@RequestBody Employee emp) {
		return repository.save(emp);

	}
	

	@PutMapping("/update/{id}/{name}")
	public Employee update(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {

		Employee emp = repository.getOne(id);
		emp.setName(name);

		return repository.save(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	
	}
	
}
