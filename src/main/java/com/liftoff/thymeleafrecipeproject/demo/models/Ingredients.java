package com.liftoff.thymeleafrecipeproject.demo.models;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ingredients extends AbstractEntity {

    @NotBlank
    private String ingredients;

    @OneToOne(mappedBy = "recipeIngredients")
    private Recipe recipe;

    public Ingredients(@NotBlank String ingredients){
        this.ingredients = ingredients;
    }

    public Ingredients(){}

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
