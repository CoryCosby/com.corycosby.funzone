package com.corycosby.funzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corycosby.funzone.model.User;

@Repository // Indicates UserRepository as a @Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	
	// Custom query to find all users whose first name starts with a O
    @Query("SELECT u FROM User u WHERE u.firstName LIKE 'O%'")
    List<User> findByFirstNameStartsWithO();

    // Custom query to find each user whose last name starts with s
    @Query("SELECT u FROM User u WHERE u.lastName LIKE 's%'")
    List<User> findByLastNameStartsWithS();

    // Custom query to find each user with an email address that ends with @perscholasrocks.com
    @Query("SELECT u FROM User u WHERE u.email LIKE '%@perscholasrocks.com'")
    List<User> findByEmailEndsWithPerscholasrocksDotCom();
}