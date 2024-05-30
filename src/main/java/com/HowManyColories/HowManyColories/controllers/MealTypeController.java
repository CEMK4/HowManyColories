package com.HowManyColories.HowManyColories.controllers;


import com.HowManyColories.HowManyColories.entities.DTOs.MealDto;
import com.HowManyColories.HowManyColories.entities.DTOs.MealTypeDto;
import com.HowManyColories.HowManyColories.services.MealService;
import com.HowManyColories.HowManyColories.services.MealTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meal-types")
@RequiredArgsConstructor
public class MealTypeController {
    private final MealTypeService mealTypeService;

    @GetMapping()
    public ResponseEntity<?> getAllMeals(@PathVariable Long userID)
    {
        return ResponseEntity.ok(mealTypeService.getAllMealType(userID));
    }

    @GetMapping("/{mealTypeID}")
    public ResponseEntity<?> getMeal(@PathVariable Long mealID)
    {
        return ResponseEntity.ok(mealTypeService.getMealType(mealID));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMeal(@PathVariable Long userID,
                                        @RequestParam("mealTypeTitle") String mealTypeTitle)
    {
        MealTypeDto mealTypeDto = mealTypeService.createMealType(userID, mealTypeTitle);
        return new ResponseEntity<>(mealTypeDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{mealTypeID}/delete")
    public ResponseEntity<?> deleteMeal(@PathVariable Long mealID)
    {
        mealTypeService.deleteMealType(mealID);
        return ResponseEntity.ok().body("");
    }
}
