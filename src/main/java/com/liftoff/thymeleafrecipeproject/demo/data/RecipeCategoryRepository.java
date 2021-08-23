package com.liftoff.thymeleafrecipeproject.demo.data;

import com.liftoff.thymeleafrecipeproject.demo.models.RecipeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
}