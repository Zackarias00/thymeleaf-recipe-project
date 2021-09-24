package com.liftoff.thymeleafrecipeproject.demo.controllers;

import com.liftoff.thymeleafrecipeproject.demo.data.RecipeRepository;
import com.liftoff.thymeleafrecipeproject.demo.models.Recipe;
import com.liftoff.thymeleafrecipeproject.demo.models.RecipeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("recipes/search")
public class SearchController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("")
    public String search(Model model) {
        return "recipes/search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchTerm){
        Iterable<Recipe> recipes;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            recipes = recipeRepository.findAll();
        } else {
            recipes = RecipeData.findByValue(searchTerm, recipeRepository.findAll());
        }
        model.addAttribute("recipes", recipes);

        return "recipes/search";
    }
}