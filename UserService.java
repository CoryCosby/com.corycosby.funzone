package com.corycosby.funzone.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.corycosby.funzone.model.User;
import com.corycosby.funzone.web.dto.UserRegistrationDto;
@Service
public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto); // Saves new user in database by taking UserRegistrationDto(has users info) object as input, returns user object
	void updateProfile(UserRegistrationDto user);	// Updates existing user in database, by taking UserRegistrationDto(has users info) object as input, no return value
	User findUserById(Long id);	// Locates user by their unique id
	User findByEmail(String email); // Locates user by their email
	void deleteLastName(Long userId); // Delete the user's last name
}