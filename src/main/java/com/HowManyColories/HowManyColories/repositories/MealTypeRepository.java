package com.HowManyColories.HowManyColories.repositories;

import com.HowManyColories.HowManyColories.entities.MealType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealTypeRepository extends JpaRepository<MealType, Long> {
    MealType findByTitle(String title);
}