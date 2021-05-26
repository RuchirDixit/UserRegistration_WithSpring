package com.bridgelabz.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.workshop.model.UserData;

public interface UserRegistrationRepository extends JpaRepository<UserData, Integer> {

}
