package com.bridgelabz.workshop.services;

import java.util.List;

import com.bridgelabz.workshop.dto.UserDTO;
import com.bridgelabz.workshop.model.UserData;

public interface IUserRegistrationService {

	List<UserData> getAllUsers();

	UserData addNewUser(UserDTO dto);

	UserData updateUser(int id, UserDTO dto);

	void deleteUserById(int id);

}
