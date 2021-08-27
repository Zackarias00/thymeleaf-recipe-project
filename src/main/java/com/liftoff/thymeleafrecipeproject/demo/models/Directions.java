package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Directions extends AbstractEntity {

    @NotBlank
    private String directions;

    @OneToOne(mappedBy = "recipeDirections")
    private Recipe recipe;

    public Directions(@NotBlank String directions){
        this.directions = directions;
    }

    public Directions(){}

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
