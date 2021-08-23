package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipeCategory extends AbstractEntity {

    @Size(min=3, message="Name must be at least 3 characters long.")
    private String name;

    @OneToMany(mappedBy = "recipeCategory")
    private final List<Recipe> recipes = new ArrayList<>();

    public RecipeCategory(@Size(min=3, message="Name must be at least 3 characters long.") String name){
        this.name = name;
    }

    public RecipeCategory(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString(){return name;}
}

