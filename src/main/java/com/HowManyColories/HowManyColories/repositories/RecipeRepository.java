package com.HowManyColories.HowManyColories.repositories;

import com.HowManyColories.HowManyColories.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}