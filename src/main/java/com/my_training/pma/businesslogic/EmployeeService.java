package com.my_training.pma.businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_training.pma.dao.EmployeeRepository;
import com.my_training.pma.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	//prova co
	public UUID createEmployee( EmployeeDTO newEmployeeDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Employee newEmployee= modelMapper.map(newEmployeeDTO, Employee.class);
		return empRepo.save(newEmployee).getId();
		
	}
	
	
public List<EmployeeDTO> findAll(){
		
		List<EmployeeDTO> employeeList = new ArrayList<>();
		
		empRepo.findAll().forEach(emp->employeeList.add(new ModelMapper().map(emp, EmployeeDTO.class)));
		
		return employeeList; 
	}


public EmployeeDTO findOne (UUID employeID) {
EmployeeDTO employeeDTO = new EmployeeDTO();
	
	ModelMapper modelMapper = new ModelMapper();
	employeeDTO =  modelMapper.map(empRepo.findById(employeID).get(), EmployeeDTO.class);
	return employeeDTO;
}

public void update(EmployeeDTO newEmployeeDTO, UUID employeeID) {
	
	Employee newEmployee = empRepo.findById(employeeID).get();
	
	ModelMapper mapper = new ModelMapper();
	newEmployee= mapper.map(newEmployeeDTO, Employee.class);
	
	empRepo.save(newEmployee);
}


public void delete(UUID employeID) {
	empRepo.deleteById(employeID);
}


}
