package com.genesis.data;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.genesis.exceptions.DataInconsistantException;
import com.genesis.model.Employee;

/**
 * @author nisshukl0
 *
 */
@Repository
public class EmployeeRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepository.class);
	private Map<Long, Employee> employeesMap;

	/**
	 *
	 */
	public EmployeeRepository() {

		if (null == employeesMap) {
			employeesMap = new HashMap<>();
		}
	}

	/**
	 * @param id
	 * @return
	 */
	public Employee getEmployee(long id) {

		LOGGER.info("checking records for id: {}", id);
		if (employeesMap.containsKey(id)) {
			LOGGER.info("found records for id: {}", id);
			return employeesMap.get(id);
		}
		LOGGER.info("found no records for id: {}", id);
		Employee employee = new Employee("Bot", "Employee", id, new Date(22091992));
		LOGGER.info("created and updated Bot records for id: {}", id);
		employeesMap.put(id, employee);
		return employee;
	}

	/**
	 * @return
	 */
	public Collection<Employee> getAllEmployees() {
		LOGGER.info("Reading Records for all Employess present in DB");
		return employeesMap.values();
	}

	/**
	 * @param employee
	 * @return
	 * @throws DataInconsistantException
	 */
	public Employee addEmployee(Employee employee) throws DataInconsistantException {

		LOGGER.info("checking in employee records for id: {}", employee.getId());
		if (employeesMap.containsKey(employee.getId())) {
			LOGGER.info("records already exist for id: {}", employee.getId());
			throw new DataInconsistantException();
		}
		LOGGER.info("found no records for id: {}", employee.getId());
		employeesMap.put(employee.getId(), employee);
		LOGGER.info("updated records for id: {}", employee.getId());
		return employee;
	}

	/**
	 * @param id
	 * @return
	 * @throws DataInconsistantException
	 */
	public Employee deleteEmployee(Long id) throws DataInconsistantException {

		LOGGER.info("checking in employee records for id: {}", id);
		if (employeesMap.containsKey(id)) {
			LOGGER.info("found records for id: {}", id);
			Employee employee = employeesMap.get(id);
			employeesMap.remove(id);
			return employee;
		}
		throw new DataInconsistantException();
	}

}
