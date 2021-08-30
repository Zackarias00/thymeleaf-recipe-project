package com.liftoff.thymeleafrecipeproject.demo.data;

import com.liftoff.thymeleafrecipeproject.demo.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Blob;

@Repository
public interface ImageRepository extends JpaRepository<Image, Blob> {

}
