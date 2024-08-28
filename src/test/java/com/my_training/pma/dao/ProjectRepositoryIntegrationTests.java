//package com.my_training.pma.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.platform.commons.util.CollectionUtils;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
//import org.springframework.test.context.jdbc.SqlGroup;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.my_training.pma.ProjectManagementApplication;
//import com.my_training.pma.dao.ProjectRepository;
//import com.my_training.pma.entities.EProjectStage;
//import com.my_training.pma.entities.Project;
//import junit.framework.Assert;
//
//
////@ContextConfiguration(classes=ProjectManagementApplication.class)
//@SpringBootTest
////@DataJpaTest
//@RunWith(SpringRunner.class)
//@SqlGroup({@Sql(executionPhase= ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:schema.sql", "classpath:data.sql"} ),
//	@Sql(executionPhase= ExecutionPhase.AFTER_TEST_METHOD,scripts = {"classpath:drop.sql"} )})
//
//class ProjectRepositoryIntegrationTests {
//	@Autowired
//	ProjectRepository proRepo;
//	
//	@Test
//	public void ifNewProjectSavedThenSuccess() {
//		Project newProject = new Project("New test project", EProjectStage.COMPLETED, "test description");
//		
//
//		proRepo.save(newProject);
//				
//		Iterable<Project> projects = proRepo.findAll();
//		List<Project> projectList = new ArrayList<>();
//		projects.forEach(projectList::add);
//
//		/// Asset equals from jUnit ensure that the actual size of projectList is 5;
//		Assert.assertEquals(5, projectList.size());
//		
//	}
//}