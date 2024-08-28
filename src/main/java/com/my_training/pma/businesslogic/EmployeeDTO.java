package com.my_training.pma.businesslogic;


import java.util.UUID;

import com.my_training.pma.entities.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

	private UUID id;
	
	private String firstName;
	private String lastName;
	private String email;
	private Project project;
	
}


