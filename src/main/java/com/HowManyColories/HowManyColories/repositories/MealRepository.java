package com.HowManyColories.HowManyColories.repositories;

import com.HowManyColories.HowManyColories.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}