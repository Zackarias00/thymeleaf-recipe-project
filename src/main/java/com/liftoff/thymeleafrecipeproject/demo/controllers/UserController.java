package com.liftoff.thymeleafrecipeproject.demo.controllers;

import com.liftoff.thymeleafrecipeproject.demo.data.RecipeRepository;
import com.liftoff.thymeleafrecipeproject.demo.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String displayProfilePage(Model model){
        return "profile";
    }
}
