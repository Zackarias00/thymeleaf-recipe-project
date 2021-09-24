package com.liftoff.thymeleafrecipeproject.demo.models;

import java.util.ArrayList;
import java.util.Locale;

public class RecipeData {

    public static ArrayList<Recipe> findByValue(String value, Iterable<Recipe> allRecipes){

        String lower_val = value.toLowerCase();

        ArrayList<Recipe> results = new ArrayList<>();

        for(Recipe recipe : allRecipes){
            if(recipe.getName().toLowerCase().contains(lower_val)){
                results.add(recipe);
            } else if(recipe.getRecipeDirections().getDirections().toLowerCase().contains(lower_val)){
                results.add(recipe);
            } else if(recipe.getRecipeDescription().getDescription().toLowerCase().contains(lower_val)){
                results.add(recipe);
            } else if(recipe.getRecipeIngredients().getIngredients().toLowerCase().contains(lower_val)){
                results.add(recipe);
            } else if(recipe.getRecipeCategory().toString().toLowerCase().contains(lower_val)){
                results.add(recipe);
            }
        }

        return results;
    }

}
