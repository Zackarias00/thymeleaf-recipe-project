package com.liftoff.thymeleafrecipeproject.demo.controllers;


import com.liftoff.thymeleafrecipeproject.demo.data.RecipeCategoryRepository;
import com.liftoff.thymeleafrecipeproject.demo.data.RecipeRepository;
import com.liftoff.thymeleafrecipeproject.demo.models.Recipe;
import com.liftoff.thymeleafrecipeproject.demo.models.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping
    public String displayRecipes(@RequestParam(required=false) Integer categoryId, Model model){
        if(categoryId==null){
            model.addAttribute("title", "All Recipes");
            model.addAttribute("recipes",recipeRepository.findAll());
        } else {
            Optional<RecipeCategory> result = recipeCategoryRepository.findById(categoryId);
            if(result.isEmpty()){
                model.addAttribute("title","Invalid Category ID: " + categoryId);
            } else {
                RecipeCategory category = result.get();
                model.addAttribute("title", "Recipes in category: " + category.getName());
                model.addAttribute("recipes", category.getRecipes());
            }
        }

        return "recipes/index";
    }

    @GetMapping("create")
    public String displayAddRecipeForm(Model model){
        model.addAttribute("title", "Add Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("categories",recipeCategoryRepository.findAll());
        return "recipes/create";
    }

    @PostMapping("create")
    public String processAddRecipeForm(@ModelAttribute @Valid Recipe newRecipe, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Recipe");
            return "recipes/create";
        }

        recipeRepository.save(newRecipe);
        return "redirect:";
    }

    @GetMapping("detail")
    public String displayRecipeDetails(@RequestParam Integer recipeId, Model model){
        Optional<Recipe> result = recipeRepository.findById(recipeId);

        if(result.isEmpty()){
            model.addAttribute("title","Invalid Recipe ID:");
        } else {
            Recipe recipe = result.get();
            model.addAttribute("title",recipe.getName() + " Details");
            model.addAttribute("recipe", recipe);
        }

        return "recipe/detail";
    }


}
