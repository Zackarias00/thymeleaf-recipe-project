package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class RecipeDescription extends AbstractEntity {

    @Size(min = 0, max = 500, message = "Description too long!")
    private String description;

    @OneToOne(mappedBy = "recipeDescription")
    private Recipe recipe;

    public RecipeDescription(@Size(min=0,max=500,message="Description too long!") String description){
        this.description = description;
    }

    public RecipeDescription(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

