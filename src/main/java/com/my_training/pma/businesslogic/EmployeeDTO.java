package com.my_training.pma.businesslogic;


import java.util.UUID;

import com.my_training.pma.entities.Project;
import jakarta.validation.constraints.NotNull;

public record EmployeeDTO (

		UUID id,
						   @NotNull(message="Firstname is required")
						   String firstName,
							@NotNull(message="LastName is required")
						   String lastName,
		                   @NotNull(message="Email is required")
						   String email,
						   Project project )
{

}


