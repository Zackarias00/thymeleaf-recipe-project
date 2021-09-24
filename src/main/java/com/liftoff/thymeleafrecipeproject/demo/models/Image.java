package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class Image extends AbstractEntity{


    @NotNull
    private String image;

    @OneToOne(mappedBy = "recipeImage")
    private Recipe recipe;

    public Image(@NotNull String image){
        this.image = image;
    }

    public Image(){}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
