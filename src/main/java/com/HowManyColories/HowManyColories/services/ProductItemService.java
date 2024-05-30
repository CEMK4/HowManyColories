package com.HowManyColories.HowManyColories.services;

import com.HowManyColories.HowManyColories.entities.DTOs.MealDto;
import com.HowManyColories.HowManyColories.entities.DTOs.ProductItemDto;
import com.HowManyColories.HowManyColories.entities.Meal;
import com.HowManyColories.HowManyColories.entities.ProductItem;
import com.HowManyColories.HowManyColories.repositories.ProductItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductItemService {
    private final ProductItemRepository productItemRepository;

    public List<ProductItemDto> getAllProductItems()
    {
        return productItemRepository.findAll().stream().map(this::createProductItem).toList();
    }

    public ProductItemDto getProductItem(Long productItemId)
    {
        return createProductItem(productItemRepository.findById(productItemId).get());
    }

    public ProductItemDto createProductItem(ProductItemDto productItemDto) {
        var productItem = productItemRepository.save(new ProductItem(productItemDto.getTitle(), productItemDto.getCalories(), productItemDto.getFats(), productItemDto.getFats(), productItemDto.getCarbs()));
        return createProductItem(productItem);
    }

    public void deleteProductItem(Long productItemID)
    {
        productItemRepository.delete(productItemRepository.findById(productItemID).get());
    }

    public ProductItemDto updateProductItem(Long productItemId, ProductItemDto productItemDto)
    {
        var productItem = productItemRepository.findById(productItemId).get();
        productItem.setTitle(productItemDto.getTitle());
        productItem.setCalories(productItemDto.getCalories());
        productItem.setProteins(productItemDto.getProteins());
        productItem.setFats(productItemDto.getFats());
        productItem.setCarbs(productItemDto.getCarbs());

        return createProductItem(productItemRepository.save(productItem));
    }

    public ProductItemDto createProductItem(ProductItem productItem) {
        return new ProductItemDto(productItem.getTitle(), productItem.getCalories(), productItem.getProteins(), productItem.getFats(), productItem.getCarbs());
    }
}
