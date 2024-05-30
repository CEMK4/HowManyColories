package com.HowManyColories.HowManyColories.entities.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link com.HowManyColories.HowManyColories.entities.Meal}
 */
@Data
public class MealDto implements Serializable {
    @NotNull
    MealTypeDto mealType;
    @NotNull
    Set<UsedProductDto> usedProducts;
    @NotNull
    @PastOrPresent
    LocalDate date;

    public MealDto(MealTypeDto mealTypeDto, Set<UsedProductDto> usedProducts, @PastOrPresent @NotNull LocalDate date)
    {
        this.mealType = mealTypeDto;
        this.usedProducts = usedProducts;
        this.date = LocalDate.now();
    }
}