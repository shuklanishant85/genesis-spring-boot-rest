package com.genesis.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.data.EmployeeRepository;
import com.genesis.exceptions.DataInconsistantException;
import com.genesis.model.Employee;

@RestController
public class GatewayController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GatewayController.class);
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = "/access", method = RequestMethod.GET)
	public String getAccess() {
		LOGGER.info("request for access");
		return "Access Granted";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee getEmployee(@RequestParam(value = "id", defaultValue = "125645") Long id) {
		LOGGER.info("getting user with id: {}", id);
		return employeeRepository.getEmployee(id);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		LOGGER.info("getting all employees");
		return new ArrayList<Employee>(employeeRepository.getAllEmployees());
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) throws DataInconsistantException {
		LOGGER.info("adding new user with id: {}", employee.getId());
		return employeeRepository.addEmployee(employee);
	}

	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
	public Employee deleteEmployee(@PathVariable(value = "id") Long id) throws DataInconsistantException {
		LOGGER.info("deleting user with id: {}", id);
		return employeeRepository.deleteEmployee(id);
	}
}
