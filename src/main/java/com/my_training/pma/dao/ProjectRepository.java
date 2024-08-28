package com.my_training.pma.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my_training.pma.entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, UUID>{

//	@Query(nativeQuery= true, value="select p.stage as label , count(*)  as value  from project p \r\n"
//			+ "group by p.stage ")
//	public List<ChartData> getProjectStatus();
}
