package com.HowManyColories.HowManyColories.services;

import com.HowManyColories.HowManyColories.entities.DTOs.MealTypeDto;
import com.HowManyColories.HowManyColories.entities.DTOs.ProductItemDto;
import com.HowManyColories.HowManyColories.entities.DTOs.UsedProductDto;
import com.HowManyColories.HowManyColories.entities.ProductItem;
import com.HowManyColories.HowManyColories.entities.UsedProduct;
import com.HowManyColories.HowManyColories.repositories.MealRepository;
import com.HowManyColories.HowManyColories.repositories.ProductItemRepository;
import com.HowManyColories.HowManyColories.repositories.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsedProductService {
    private final UsedProductRepository usedProductRepository;
    private final ProductItemRepository productItemRepository;
    private final MealRepository mealRepository;

    public List<UsedProductDto> getAllUsedProducts(Long mealID) {
        return usedProductRepository.findByMeal_Id(mealID).stream()
                .map(this::createUsedProductDto)
                .collect(Collectors.toList());
    }

    public UsedProductDto getUsedProduct(Long usedProductID) {
        var usedProductOpt = usedProductRepository.findById(usedProductID);
        return usedProductOpt.map(this::createUsedProductDto).orElse(null);
    }

    public UsedProductDto createUsedProduct(Long mealID, UsedProductDto usedProductDto) {
        UsedProduct usedProduct = new UsedProduct();
        usedProduct.setMeasure(usedProductDto.getMeasure());

        var productItemOpt = productItemRepository.findById(usedProductDto.getProductItemId());
        productItemOpt.ifPresent(usedProduct::setProductItem);

        var mealOpt = mealRepository.findById(mealID);
        mealOpt.ifPresent(usedProduct::setMeal);

        UsedProduct savedUsedProduct = usedProductRepository.save(usedProduct);
        return createUsedProductDto(savedUsedProduct);
    }

    public UsedProductDto updateUsedProduct(Long usedProductID, UsedProductDto usedProductDto) {
        var usedProductOpt = usedProductRepository.findById(usedProductID);
        if (usedProductOpt.isPresent()) {
            UsedProduct usedProduct = usedProductOpt.get();
            usedProduct.setMeasure(usedProductDto.getMeasure());

            var productItemOpt = productItemRepository.findById(usedProductDto.getProductItemId());
            productItemOpt.ifPresent(usedProduct::setProductItem);

            var mealOpt = mealRepository.findById(usedProductDto.getMealId());
            mealOpt.ifPresent(usedProduct::setMeal);

            UsedProduct updatedUsedProduct = usedProductRepository.save(usedProduct);
            return createUsedProductDto(updatedUsedProduct);
        }
        return null;
    }

    public void deleteUsedProduct(Long usedProductID) {
        usedProductRepository.deleteById(usedProductID);
    }

    public UsedProductDto createUsedProductDto(UsedProduct usedProduct) {
        return new UsedProductDto(
                usedProduct.getId(),
                usedProduct.getMeasure(),
                usedProduct.getProductItem().getId(),
                usedProduct.getMeal().getId()
        );
    }

    public UsedProduct addUsedProduct(Long mealID, UsedProductDto usedProductDto) {
        UsedProduct usedProduct = new UsedProduct();
        usedProduct.setMeasure(usedProductDto.getMeasure());

        var productItemOpt = productItemRepository.findById(usedProductDto.getProductItemId());
        productItemOpt.ifPresent(usedProduct::setProductItem);

        var mealOpt = mealRepository.findById(mealID);
        mealOpt.ifPresent(usedProduct::setMeal);

        return usedProductRepository.save(usedProduct);
    }
}
