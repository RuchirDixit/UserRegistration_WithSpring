package com.bridgelabz.workshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.workshop.dto.ResponseDTO;
import com.bridgelabz.workshop.dto.UserDTO;
import com.bridgelabz.workshop.model.UserData;
import com.bridgelabz.workshop.services.IUserRegistrationService;

@RestController
@RequestMapping("/user")
public class UseRegistrationController {

	@Autowired
	public IUserRegistrationService userRegistrationService;
	
	@GetMapping("/getUsers")
	public ResponseEntity<ResponseDTO> getAllUsers(){
		List<UserData> userList = userRegistrationService.getAllUsers();
		ResponseDTO responseDTO = new ResponseDTO("Get all users", userList);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<ResponseDTO> addNewUsers(@Valid @RequestBody UserDTO dto){
		UserData userData = userRegistrationService.addNewUser(dto);
		ResponseDTO responseDTO = new ResponseDTO("New User Added", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<ResponseDTO> updateUser(@Valid @RequestParam("id") int id,@RequestBody UserDTO dto){
		UserData userData = userRegistrationService.updateUser(id,dto);
		ResponseDTO responseDTO = new ResponseDTO("User Updated", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable int id){
		userRegistrationService.deleteUserById(id);
		ResponseDTO responseDTO = new ResponseDTO("User Updated", "User With Id: "+id+" Deleted!");
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
}
