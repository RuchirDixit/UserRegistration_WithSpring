package com.bridgelabz.workshop.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.workshop.dto.UserDTO;

import lombok.Data;

@Entity
@Table(name = "users")
public @Data class UserData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int ID;
	private String firstName;
	private String lastName;
	private int age;
	private Long mobileNumber;
	private String registrationTime;
	
	public UserData () {}
	public UserData(UserDTO userDTO){
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		this.registrationTime = dateTimeFormat.format(now);
		this.updateUserData(userDTO);
	}

	public void updateUserData(UserDTO userDTO) {
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.mobileNumber = userDTO.getMobileNumber();
		this.age = userDTO.getAge();
	}
}
