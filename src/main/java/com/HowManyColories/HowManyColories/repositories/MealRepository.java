package com.HowManyColories.HowManyColories.repositories;

import com.HowManyColories.HowManyColories.entities.DTOs.MealDto;
import com.HowManyColories.HowManyColories.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<MealDto> findByUser_Id(Long id);

    @Override
    Optional<Meal> findById(Long aLong);
}