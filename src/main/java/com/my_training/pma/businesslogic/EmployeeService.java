package com.my_training.pma.businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.my_training.pma.exception.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_training.pma.dao.EmployeeRepository;
import com.my_training.pma.entities.Employee;

@Service
public class EmployeeService {
	

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository){
		this.employeeRepository=employeeRepository;
	}

	public UUID saveNewEmployee( EmployeeDTO newEmployeeDTO) {

		Employee newEmployee= new Employee(
				newEmployeeDTO.firstName(),
				newEmployeeDTO.lastName(),
				newEmployeeDTO.email(),
				newEmployeeDTO.project()
		);
		return employeeRepository.save(newEmployee).getId();
	}
	
	
public List<EmployeeDTO> getAllEmployees(){
		
		List<EmployeeDTO> employeeList = new ArrayList<>();
	employeeRepository.findAll().forEach(
			emp->{
				EmployeeDTO ep= new EmployeeDTO(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getProject());
				employeeList.add(ep);
			});
		return employeeList; 
	}


public EmployeeDTO getEmployeeById (UUID id) {

	return employeeRepository.findById(id).map(
			emp-> new EmployeeDTO(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getProject())
	).orElseThrow(  () ->  new IllegalArgumentException("Resource whiht id: "+ id+ " not found" ));
}

public void updateEmployeById(EmployeeDTO newEmployee, UUID id) {
	
	Employee emp = employeeRepository.findById(id)
			.orElseThrow(()-> new ResourceNotFound("employee whiht id: "+ id + " not found"));

	if(newEmployee.firstName()!=null && !newEmployee.firstName().equals(emp.getFirstName())){
		emp.setFirstName(newEmployee.firstName());
	}

	if(newEmployee.lastName()!=null && !newEmployee.lastName().equals(emp.getLastName())){
		emp.setLastName(newEmployee.lastName());
	}

	if(newEmployee.email()!=null && !newEmployee.email().equals(emp.getEmail())){
		emp.setEmail(newEmployee.email());
	}
	employeeRepository.save(emp);
}


public void deleteEmployeById(UUID id) {
		boolean isExist = employeeRepository.existsById(id);
		if(!isExist){
			throw  new ResourceNotFound( "Employee with id [" + id + "] not found");
		}
		employeeRepository.deleteById(id);
}


}
