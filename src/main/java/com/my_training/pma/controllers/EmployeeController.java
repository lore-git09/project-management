package com.my_training.pma.controllers;

import java.util.List;
import java.util.UUID;

import com.my_training.pma.businesslogic.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_training.pma.businesslogic.EmployeeDTO;
import com.my_training.pma.businesslogic.EmployeeService;
@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService){
		this.employeeService= employeeService;
	}
	
	
	@PostMapping()
	public UUID createNewEmployee(@RequestBody @Valid EmployeeDTO empDTO) {
		return employeeService.saveNewEmployee(empDTO);
	}
	
	@GetMapping()
	public List<EmployeeDTO> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public EmployeeDTO findOne(
			@PathVariable("id") UUID employeeID){
		return employeeService.getEmployeeById(employeeID);
	}
	
	@PutMapping("{id}")
	public void updateEmployeById(@PathVariable("id") UUID employeeID, @RequestBody @Valid EmployeeDTO newEmpDTO) {
		employeeService.updateEmployeById(newEmpDTO, employeeID);
		
	}
	
	@DeleteMapping("{id}")
	public void deleteEmployeById(@RequestParam("id") UUID employeeID) {
		employeeService.deleteEmployeById(employeeID);
	}

}
