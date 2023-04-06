package com.corycosby.funzone.controller;

import com.corycosby.funzone.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Marks the MainController as a Spring MVS controller
@RequestMapping("/")
public class MainController {

    // Maps the /login URL to the login() method
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Maps the / URL to the home() method
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Maps the /aboutus URL to the aboutUs() method
    @GetMapping("/aboutus")
    public String aboutUs() {
        return "aboutus";
    }

    // Maps the /rockpaperscissors URL to the rockPaperScissors() method
    @GetMapping("/rockpaperscissors")
    public String rockPaperScissors() {
        return "rockpaperscissors";
    }

    // Maps the /profile URL to the showProfilePage() method
    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        // Creates a new User object and adds it to the model
        User user = new User();
        model.addAttribute("user", user);
        return "profile";
    }
}



