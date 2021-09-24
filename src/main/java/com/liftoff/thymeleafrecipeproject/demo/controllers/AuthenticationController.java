package com.liftoff.thymeleafrecipeproject.demo.controllers;


import com.liftoff.thymeleafrecipeproject.demo.data.UserRepository;
import com.liftoff.thymeleafrecipeproject.demo.models.dto.LoginFormDTO;
import com.liftoff.thymeleafrecipeproject.demo.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.liftoff.thymeleafrecipeproject.demo.models.User;
import org.springframework.validation.Errors;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if(userId == null){
            return null;
        }

        Optional<User> user = userRepository.findById(userId);


        if(user.isEmpty()){
            return null;
        }

        return user.get();
    }


    private static void setUserInSession(HttpSession session, User user){
        session.setAttribute(userSessionKey,user.getId());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model){
        model.addAttribute(new RegisterFormDTO());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO, Errors errors, HttpServletRequest request, Model model){


        if(errors.hasErrors()){

            return "register";
        }

        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        if(existingUser != null){
            errors.rejectValue("username","username.alreadyExists", "A user with that username already exists");
            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if(!password.equals(verifyPassword)){
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            return "register";
        }

        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:/recipes";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model){
        model.addAttribute(new LoginFormDTO());
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO, Errors errors, HttpServletRequest request, Model model){
        if(errors.hasErrors()){
            return "login";
        }

        User theUser = userRepository.findByUsername((loginFormDTO.getUsername()));

        if(theUser == null){
            errors.rejectValue("username", "user.invalid", "The given username does not exist.");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if(!theUser.isMatchingPassword(password)){
            errors.rejectValue("password","password.invalid","Invalid password");
            return "login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:/recipes";

    }


    @GetMapping("")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/recipes";
    }


}
