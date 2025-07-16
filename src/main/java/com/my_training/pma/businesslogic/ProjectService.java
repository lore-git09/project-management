package com.my_training.pma.businesslogic;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.my_training.pma.entities.EProjectStage;
import com.my_training.pma.exception.ResourceNotFound;
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
	
	
	public UUID saveNewProject(ProjectDTO newProjectdto) {
		Project p = new Project();
		p.setName(newProjectdto.name());
		p.setStage(EProjectStage.valueOf(newProjectdto.stage()));
		p.setDescription(newProjectdto.description());
		p.setEmployees(newProjectdto.employeeList());
		return projectRepository.save(p).getId();
	}
	
	public List<ProjectDTO> getAllProjects(){
		
		List<ProjectDTO> projectList = new ArrayList<>();
		projectRepository.findAll().forEach(
				p->{
					ProjectDTO pro =new ProjectDTO(
							p.getId(),
							p.getName(),
							p.getStage().toString(),
							p.getDescription(),
							p.getEmployees()
					);
					projectList.add(pro);
				});
		return projectList; 
	}
	
	public ProjectDTO getProjectById (UUID id) {
		return projectRepository.findById(id).map(
				p-> new ProjectDTO(
							p.getId(),
							p.getName(),
							p.getStage().toString(),
							p.getDescription(),
							p.getEmployees()
					)
		).orElseThrow(()-> new ResourceNotFound( "Project with id: "+ id + " does'nt exist"));
		}

		public void updateProjectById(ProjectDTO newProjectDTO, UUID id) {
			Project project = projectRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFound( "Project with id: "+ id + " does'nt exist"));

			if(newProjectDTO.name() !=null && !newProjectDTO.name().equals(project.getName())){
				project.setName(newProjectDTO.name());
			}
			if(newProjectDTO.description() !=null && !newProjectDTO.description().equals(project.getDescription())){
				project.setDescription(newProjectDTO.description());
			}
			if(newProjectDTO.stage() !=null){
				project.setStage(EProjectStage.valueOf(newProjectDTO.stage()));
			}
			projectRepository.save(project);
		}

		public void  deleteProjectById(UUID id){
			Project project = projectRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFound( "Project with id: "+ id + " does'nt exist"));
			project.setDeletedAt(Instant.now());
			projectRepository.save(project);

		}

	
	
	
	

}
