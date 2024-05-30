package com.HowManyColories.HowManyColories.entities.DTOs;

import com.HowManyColories.HowManyColories.entities.UsedProduct;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.HowManyColories.HowManyColories.entities.UsedProduct}
 */
@Data
public class UsedProductDto implements Serializable {
    @NotNull
    @NotEmpty
    @NotBlank
    String measure;
    @NotNull
    ProductItemDto productItem;

    public UsedProductDto(String measure, ProductItemDto productItemDto)
    {
        this.measure = measure;
        this.productItem = productItemDto;
    }

    public UsedProductDto(Long id, String measure, Long id1, Long id2) {
    }
}