package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Entity
public class Image extends AbstractEntity {


    @NotNull
    private Blob image;

    @OneToOne(mappedBy = "image")
    private Recipe recipe;

    public Image(@NotNull Blob image){
        this.image = image;
    }

    public Image(){}

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
