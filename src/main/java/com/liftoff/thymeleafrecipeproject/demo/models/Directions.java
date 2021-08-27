package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Directions extends AbstractEntity {

    @NotNull
    private String directions;

    @ManyToOne
    private Recipe recipe;

    public Directions(@NotNull String directions){
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
