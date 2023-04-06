package com.corycosby.funzone.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.corycosby.funzone.model.Role;
import com.corycosby.funzone.model.User;
import com.corycosby.funzone.repository.UserRepository;
import com.corycosby.funzone.web.dto.UserRegistrationDto;

@Component // Indicates UserServiceImpl as a Spring Bean
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired // Auto injects dependencies
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override 
    public User save(UserRegistrationDto registrationDto) {
        // Creates a new User object with the data from registrationDto and encodes the password with BCryptPasswordEncoder
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        // Saves the new user object to the database
        return userRepository.save(user);
    }

    // Retrieves a user with the given username from the database and converts it to a UserDetails object
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        // Maps the user's roles to a collection of SimpleGrantedAuthority objects
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    // Maps a collection of Role objects to a collection of SimpleGrantedAuthority objects
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    // Updates the user's profile in the database with the given data
    @Override
    public void updateProfile(UserRegistrationDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());

        if (user != null) {
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());

            // placeholder for eventual addition of password reset with email verification.
            // user.setPassword(passwordEncoder.encode(userDto.getPassword()));

            userRepository.save(user);
        } else {
            // Handle the case when the user is not found.
        }
    }
    
    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public List<User> getAllUsersWhoseFirstNameStartsWithO() {
        return userRepository.findByFirstNameStartsWithO();
    }

    public List<User> getAllUsersWhoseLastNameStartsWithS() {
        return userRepository.findByLastNameStartsWithS();
    }

    public List<User> getAllUsersWithEmailEndingWithPerscholasrocksDotCom() {
        return userRepository.findByEmailEndsWithPerscholasrocksDotCom();
    }
    @Override
    public void deleteLastName(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setLastName("");
        userRepository.save(user);
    }
}

