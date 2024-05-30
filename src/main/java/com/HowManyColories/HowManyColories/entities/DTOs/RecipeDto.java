package com.HowManyColories.HowManyColories.entities.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.HowManyColories.HowManyColories.entities.Recipe}
 */
@Data
public class RecipeDto implements Serializable {
    @NotNull
    String description;
    @NotNull
    Set<ProductItemDto> productItems;
    @NotNull
    @NotEmpty
    @NotBlank
    String title;

    public RecipeDto(String description,  Set<ProductItemDto> productItems, String title)
    {
        this.description = description;
        this.productItems = productItems;
        this.title = title;
    }
}