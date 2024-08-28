package com.my_training.pma.controllers;

import java.util.List;
import java.util.UUID;

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
@RequestMapping("/api/")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	
	@PostMapping("employee/")
	public UUID create(@RequestBody EmployeeDTO empDTO) {
		return empService.createEmployee(empDTO);
	}
	
	@GetMapping("employee/")
	public List<EmployeeDTO> findAll(){
		return empService.findAll();
	}
	
	@GetMapping("employee/{employeeID}")
	public EmployeeDTO findOne(
			@PathVariable("employeeID") UUID employeeID){
		return empService.findOne(employeeID);
	}
	
	@PutMapping("employee/{employeeID}")
	public void update(@PathVariable("employeeID") UUID employeeID, @RequestBody EmployeeDTO newEmpDTO) {
		empService.update(newEmpDTO, employeeID);
		
	}
	
	@DeleteMapping("employee/{employeeID}")
	public void delete(@RequestParam("employeeID") UUID employeeID) {
	empService.delete(employeeID);
	}
	
	
	
//	public String employeeList(Model model ) {
//		
// List<EmployeeDTO>employees= empService.findAll();
//		
//		model.addAttribute("employees", employees);
//		return "employees/list-employees";
//	}
//	
//	
//	@GetMapping("/new")
//	public String displayEmployeeForm( Model model ) {
//		
//		EmployeeDTO anEmployee= new EmployeeDTO();
//		
//		model.addAttribute("employee", anEmployee);
//		
//		return "employees/new-employee";
//	}
//	
//	@PostMapping("/save")
//	public String createProject(EmployeeDTO newEmployeeDTO, Model model) {
//		empService.createEmployee(newEmployeeDTO);
//		
//		return "redirect:/employees/new";
//	}
//	
//	
}
