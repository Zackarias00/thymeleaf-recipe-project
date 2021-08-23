package com.liftoff.thymeleafrecipeproject.demo.data;


import com.liftoff.thymeleafrecipeproject.demo.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}

