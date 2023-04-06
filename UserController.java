package com.corycosby.funzone.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.corycosby.funzone.model.User;
import com.corycosby.funzone.service.UserService;
import com.corycosby.funzone.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/user")
public class UserController {

    // userService object is injected using the constructor
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/deleteLastName")
    public String deleteLastName(@RequestParam("userId") Long userId, RedirectAttributes redirectAttributes) {
        userService.deleteLastName(userId);
        redirectAttributes.addFlashAttribute("message", "Last name deleted successfully.");
        return "redirect:/user/myinfo";
    }

        // Maps the /user/updateProfile URL to the updateProfile() method using the POST HTTP method
    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute("user") UserRegistrationDto user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // If there are errors in the form data, display the profile page with error messages
            return "profile";
        }

        // Update the user's profile in the database
        userService.updateProfile(user);

        // Redirect to the updated profile page
        return "redirect:/profile";
    }
    
    @GetMapping("/myinfo")
    public String showMyInfoPage(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "myinfo";
    }
    
    @GetMapping("/deletemylastname")
    public String showDeleteLastNamePage(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "myinfo"; 
    }


}
