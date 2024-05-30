package com.HowManyColories.HowManyColories.entities.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.HowManyColories.HowManyColories.entities.MealType}
 */
@Data
public class MealTypeDto implements Serializable {
    @NotNull
    @NotEmpty
    @NotBlank
    String title;

    public MealTypeDto(String title)
    {
        this.title = title;
    }
}