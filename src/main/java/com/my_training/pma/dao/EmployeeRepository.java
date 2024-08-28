package com.my_training.pma.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my_training.pma.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, UUID> {

	//@Query(nativeQuery=true, value="")
	//public List<>employeeProjects()	;
}
