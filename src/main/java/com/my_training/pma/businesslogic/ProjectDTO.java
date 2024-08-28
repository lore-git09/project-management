package com.my_training.pma.businesslogic;

import java.util.Set;
import java.util.UUID;

import com.my_training.pma.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

	
	private UUID id;
    private String name;
	private String stage;
	private String description;
	private Set<Employee> employeeList;
	
	
	
}
