package com.liftoff.thymeleafrecipeproject.demo.models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class Image extends AbstractEntity implements Serializable {


    @NotNull
    private byte[] image;

    @OneToOne(mappedBy = "recipeImage")
    private Recipe recipe;

    public Image(@NotNull byte[] image){
        this.image = image;
    }

    public Image(){}

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
