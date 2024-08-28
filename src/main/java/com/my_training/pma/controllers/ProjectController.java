package com.my_training.pma.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_training.pma.businesslogic.ProjectDTO;
import com.my_training.pma.businesslogic.ProjectService;
import com.my_training.pma.dao.ProjectRepository;

@RestController
//@CrossOrigin(origins = "http://localhost:4200") // Permetti le richieste da http://localhost:4200
@RequestMapping("/api/")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectRepository projectRepo;
	
	/// API  method to use with whith @RestController
	
		@GetMapping("project/")
		public List<ProjectDTO> findAll() {
			return projectService.findAll();
		}
		
		@GetMapping("project/{id}/")
		public ProjectDTO findOne(@RequestParam("id") UUID projectID) {
			return projectService.findOne(projectID);	}

	
		
		@PutMapping("project/{id}")
		public void update( @RequestBody ProjectDTO projectDTO) {
			projectService.createProject(projectDTO);
		}
		@DeleteMapping("project/{projectID}")
		public void delete(@RequestParam("projectID") UUID projectID) {		projectService.delete(projectID);
		}
		
		
	
	
//	
//	@GetMapping
//	public  String ProjectList(Model model ) {
//		List<ProjectDTO>projects= projectService.findAll();
//		
//		model.addAttribute("projects", projects);
//		return "projects/list-projects";
//	}
//	
//	
//	
//	@GetMapping("/new")
//	public String displayProjectForm( Model model ) {
//		
//		ProjectDTO aProject= new ProjectDTO();
//		
//		model.addAttribute("project", aProject);
//		
//		return "projects/new-project";
//	}
//	
//	@PostMapping("/save")
//	public String createProject(ProjectDTO newProjectDTO, Model model) {
//		projectService.createProject(newProjectDTO);
//		
//		return "redirect:/projects/new";
//	}
//	
	
	
	
	
	

}
