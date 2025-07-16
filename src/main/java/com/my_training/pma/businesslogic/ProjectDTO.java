package com.my_training.pma.businesslogic;

import java.util.Set;
import java.util.UUID;

import com.my_training.pma.entities.Employee;

import jakarta.validation.constraints.NotNull;


public record ProjectDTO(
		UUID id,

		 String name,
		 String stage,
		 String description,
		Set<Employee> employeeList
) {

}
