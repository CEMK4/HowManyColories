package com.HowManyColories.HowManyColories.services;

import com.HowManyColories.HowManyColories.entities.DTOs.MealDto;
import com.HowManyColories.HowManyColories.entities.DTOs.MealTypeDto;
import com.HowManyColories.HowManyColories.entities.DTOs.UsedProductDto;
import com.HowManyColories.HowManyColories.entities.Meal;
import com.HowManyColories.HowManyColories.entities.MealType;
import com.HowManyColories.HowManyColories.entities.UsedProduct;
import com.HowManyColories.HowManyColories.entities.User;
import com.HowManyColories.HowManyColories.repositories.MealRepository;
import com.HowManyColories.HowManyColories.repositories.MealTypeRepository;
import com.HowManyColories.HowManyColories.repositories.UsedProductRepository;
import com.HowManyColories.HowManyColories.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;
    private final UserRepository userRepository;
    private final MealTypeRepository mealTypeRepository;
    private final UsedProductRepository usedProductRepository;
    private final UsedProductService usedProductService;
    private final ProductItemService productItemService;

    public List<MealDto> getAllMeals(Long userID) {
        return mealRepository.findByUser_Id(userID);
    }

    public MealDto getMeal(Long mealID) {
        return createMealDto(mealRepository.findById(mealID).get());
    }

    public MealDto createMeal(Long userID, MealTypeDto mealTypeDto, Set<UsedProductDto> usedProductDtos) {
        User user = userRepository.findById(userID).get();
        MealType mealType = mealTypeRepository.findByTitle(mealTypeDto.getTitle());

        Meal meal = new Meal();
        meal.setUser(user);
        meal.setMealType(mealType);
        meal.setDate(LocalDate.now());

        Meal savedMeal = mealRepository.save(meal);


        return createMealDto(savedMeal);
    }

    public void deleteMeal(Long mealID) {
        Meal meal = mealRepository.findById(mealID).orElseThrow();
        mealRepository.delete(meal);
    }

    public MealDto createMealDto(Meal meal) {
        MealTypeDto mealTypeDto = new MealTypeDto(meal.getMealType().getTitle());
        Set<UsedProductDto> usedProductDtos = meal.getUsedProducts()
                .stream()
                .map(up -> new UsedProductDto(up.getMeasure(), productItemService.createProductItem(up.getProductItem())))
                .collect(Collectors.toSet());
        return new MealDto(mealTypeDto, usedProductDtos, meal.getDate());
    }
}

