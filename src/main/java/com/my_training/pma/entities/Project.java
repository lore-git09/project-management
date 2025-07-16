package com.my_training.pma.entities;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.my_training.pma.entities.EProjectStage;
import org.hibernate.annotations.SQLRestriction;


@Builder
@AllArgsConstructor
@Entity
@SQLRestriction("deleted_at IS NULL")
public class Project {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EProjectStage stage;
	@Column(nullable = false)
	private String description;
	
	@OneToMany(mappedBy = "project")
	private Set<Employee> employees;

	@Column(nullable = false, updatable = false)
	private Instant createdAt;

	private Instant updatedAt;
	@Column(nullable = true, updatable = false)
	private Instant deletedAt;

	public Project(){

	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Project project = (Project) o;
		return Objects.equals(id, project.id) && Objects.equals(name, project.name) && stage == project.stage && Objects.equals(description, project.description) && Objects.equals(employees, project.employees);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, stage, description, employees);
	}

	@PrePersist
	public void prePersist(){
		this.createdAt = Instant.now();
		this.updatedAt = Instant.now();
	}

	@PreUpdate
	public void preUpdate(){
		this.updatedAt = Instant.now();
	}

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

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}
}
