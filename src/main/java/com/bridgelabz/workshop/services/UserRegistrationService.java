package com.bridgelabz.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.workshop.dto.UserDTO;
import com.bridgelabz.workshop.model.UserData;
import com.bridgelabz.workshop.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService implements IUserRegistrationService{

	@Autowired
	public UserRegistrationRepository userRegistrationRepository;
	
	@Override
	public List<UserData> getAllUsers() {
		return userRegistrationRepository.findAll();
	}
	@Override
	public UserData addNewUser(UserDTO dto) {
		UserData userData = new UserData(dto);
		return userRegistrationRepository.save(userData);
	}
	@Override
	public UserData updateUser(int id, UserDTO dto) {
		UserData userData = userRegistrationRepository.getById(id);
		userData.updateUserData(dto);
		return userRegistrationRepository.save(userData);
	}
	@Override
	public void deleteUserById(int id) {
		userRegistrationRepository.deleteById(id);
	}

}
