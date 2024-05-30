package com.HowManyColories.HowManyColories.entities.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Value;

import javax.swing.plaf.PanelUI;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.HowManyColories.HowManyColories.entities.User}
 */
@Data
public class UserDto implements Serializable {
    @NotNull
    @PositiveOrZero
    Integer age;
    @NotNull
    @Positive
    Double height;
    @NotNull
    @Positive
    Double weight;
    Set<MealDto> meals;
    @NotNull
    @Positive
    Integer caloriesConsumption;
    @NotNull
    @Positive
    Double waterConsumption;

    public UserDto(Integer age, Double height, Double weight, Set<MealDto> meals, Integer caloriesConsumption, Double waterConsumption)
    {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.meals = meals;
        this.caloriesConsumption = caloriesConsumption;
        this.waterConsumption = waterConsumption;
    }
}