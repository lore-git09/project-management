package com.my_training.pma.entities;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.my_training.pma.entities.EProjectStage;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EProjectStage getStage() {
		return stage;
	}

	public void setStage(EProjectStage stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	String name;
	
	@Enumerated(EnumType.STRING)
	 private EProjectStage stage;
	private String description;
	
	@OneToMany(mappedBy = "project")
	private Set<Employee> employees;

	
}
