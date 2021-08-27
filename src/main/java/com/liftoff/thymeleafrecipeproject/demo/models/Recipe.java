package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    @NotBlank
    @Size(min=10, max=50, message = "Recipe name must be between 10 and 50 characters.")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private RecipeDescription recipeDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Ingredients recipeIngredients;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Directions recipeDirections;

    @ManyToOne
    @NotNull(message="Category is required")
    private RecipeCategory recipeCategory;

    @OneToOne
    private Image image;

    public Recipe(String name, RecipeCategory recipeCategory, RecipeDescription recipeDescription, Ingredients recipeIngredients, Directions recipeDirections){
        this.name = name;
        this.recipeCategory = recipeCategory;
        this.recipeDescription = recipeDescription;
        this.recipeIngredients = recipeIngredients;
        this.recipeDirections = recipeDirections;
    }

    public Recipe(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeDescription getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(RecipeDescription recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {

        this.recipeCategory = recipeCategory;
    }

    public Ingredients getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Ingredients recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Directions getRecipeDirections() {
        return recipeDirections;
    }

    public void setRecipeDirections(Directions recipeDirections) {
        this.recipeDirections = recipeDirections;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString(){return name;}
}

