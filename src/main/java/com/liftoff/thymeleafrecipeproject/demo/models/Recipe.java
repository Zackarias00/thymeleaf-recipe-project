package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    @NotBlank
    @Size(min=10, max=50, message = "Recipe name must be between 10 and 50 characters.")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private RecipeDescription recipeDescription;

    @OneToMany(mappedBy = "recipe")
    @NotNull
    private final List<Ingredients> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe")
    @NotNull
    private final List<Directions> directions = new ArrayList<>();

    @ManyToOne
    @NotNull(message="Category is required")
    private RecipeCategory recipeCategory;

    public Recipe(String name, RecipeCategory recipeCategory){
        this.name = name;
        this.recipeCategory = recipeCategory;
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

    @Override
    public String toString(){return name;}
}

