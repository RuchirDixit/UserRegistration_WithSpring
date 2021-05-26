package com.bridgelabz.workshop.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class UserDTO {
	@NotBlank(message = "First name cannot be blank")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be blank")
	private String lastName;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	private LocalDate dateOfBirth;
	
	@NotNull(message = "Age cannot be null")
	private int age;
	
	private Long mobileNumber;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String firstName,String lastName,LocalDate dateOfBirth,Long mobileNumber,int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.mobileNumber = mobileNumber;
	}
}
