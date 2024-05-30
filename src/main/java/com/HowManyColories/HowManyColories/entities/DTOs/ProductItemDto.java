package com.HowManyColories.HowManyColories.entities.DTOs;

import com.HowManyColories.HowManyColories.entities.ProductItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.HowManyColories.HowManyColories.entities.ProductItem}
 */
@Data
public class ProductItemDto implements Serializable {
    @NotNull
    @NotEmpty
    @NotBlank
    String title;
    @NotNull
    @PositiveOrZero
    Double calories;
    @NotNull
    @PositiveOrZero
    Double proteins;
    @NotNull
    @PositiveOrZero
    Double fats;
    @NotNull
    @PositiveOrZero
    Double carbs;

    public ProductItemDto(String title, Double calories, Double proteins, Double fats, Double carbs)
    {
        this.title = title;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }

}