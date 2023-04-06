package com.corycosby.funzone.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corycosby.funzone.service.UserService;
import com.corycosby.funzone.web.dto.UserRegistrationDto;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    // UserService object is injected using the constructor
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    // Model attribute: returns a new UserRegistrationDto object
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    // Maps the /registration URL to the showRegistrationForm() method using the GET HTTP method
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    // Maps the /registration URL to the registerUserAccount() method using the POST HTTP method
    @PostMapping
    public ResponseEntity<String> registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        // Saves the user registration data to the database using the UserService
        userService.save(registrationDto);
        // Returns a ResponseEntity with a HTTP 302 status code and a Location header with the URL "/registration?success"
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, "/registration?success").build();
    }
}
