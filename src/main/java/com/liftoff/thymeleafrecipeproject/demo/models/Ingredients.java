package com.liftoff.thymeleafrecipeproject.demo.models;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="Ingredients")
@Table(name="ingredients")
public class Ingredients extends AbstractEntity {

    @NotNull
    private String ingredients;

    @ManyToOne
    private Recipe recipe;

    public Ingredients(@NotNull String ingredients){
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
