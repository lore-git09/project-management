package com.my_training.pma.controllers;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_training.pma.businesslogic.ProjectDTO;
import com.my_training.pma.businesslogic.ProjectService;
import com.my_training.pma.dao.ProjectRepository;

@RestController
@RequestMapping("/api/project/")
public class ProjectController {

	private final ProjectService projectService;
	 public ProjectController(ProjectService projectService){
		 this.projectService=projectService;
	 }

		@GetMapping()
		public List<ProjectDTO> getAllProjects() {

			return projectService.getAllProjects();
		}

		@PostMapping()
		public UUID saveNewProject(@RequestBody @Valid ProjectDTO projectDTO){
		 return projectService.saveNewProject(projectDTO);
		}
		
		@GetMapping("{id}")
		public ProjectDTO getProjectById(@RequestParam("id") UUID projectID) {
			return projectService.getProjectById(projectID);
	 }

		@PutMapping("{id}")
		public void update(@PathVariable UUID id, @RequestBody @Valid ProjectDTO projectDTO) {
			projectService.updateProjectById(projectDTO, id);
		}
		@DeleteMapping()
		public void deleteProjectById(@RequestParam UUID id) {projectService.deleteProjectById(id);
		}
}
