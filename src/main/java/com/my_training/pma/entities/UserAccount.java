package com.my_training.pma.entities;

import java.util.UUID;

import org.hibernate.type.EnumType;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	
	private String email;
	private String password;
	
	@Enumerated(value =jakarta.persistence.EnumType.STRING)
	private ERoleType role;
	
	private Boolean enabled;
	
	
	
	

}
