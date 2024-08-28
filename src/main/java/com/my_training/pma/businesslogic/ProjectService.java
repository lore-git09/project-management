package com.my_training.pma.businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.my_training.pma.dao.ProjectRepository;
import com.my_training.pma.entities.Project;

@Service
public class ProjectService {
	@Value("${version}")// access to a variable in the application propertie file 
	private String version;
	
	@Autowired
	ProjectRepository projectRepository;
	
	
	public UUID createProject(ProjectDTO newProjectdto) {
		ModelMapper modelMapper = new ModelMapper();
		Project newProject = modelMapper.map(newProjectdto, Project.class);
		
		return projectRepository.save(newProject).getId();		
	}
	
	public List<ProjectDTO> findAll(){
		
		List<ProjectDTO> projectList = new ArrayList<>();
		projectRepository.findAll().forEach(p->projectList.add(new ModelMapper().map(p, ProjectDTO.class)));
		return projectList; 
	}
	
	public ProjectDTO findOne (UUID projectID) {
		ProjectDTO projectDTO = new ProjectDTO();
			
			ModelMapper modelMapper = new ModelMapper();
			projectDTO =  modelMapper.map(projectRepository.findById(projectID).get(), ProjectDTO.class);
			return projectDTO;
		}

		public void update(ProjectDTO newProjectDTO, UUID projectID) {
			
			Project newProject = projectRepository.findById(projectID).get();
			
			ModelMapper mapper = new ModelMapper();
			newProject= mapper.map(newProjectDTO, Project.class);
			
			projectRepository.save(newProject);
		}


		public void delete(UUID projectID) {
			projectRepository.deleteById(projectID);
		}

	
	
	
	

}
