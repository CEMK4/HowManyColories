package com.HowManyColories.HowManyColories.controllers;


import com.HowManyColories.HowManyColories.entities.DTOs.MealDto;
import com.HowManyColories.HowManyColories.entities.DTOs.MealTypeDto;
import com.HowManyColories.HowManyColories.entities.Meal;
import com.HowManyColories.HowManyColories.services.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userID}/meals")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    @GetMapping()
    public ResponseEntity<?> getAllMeals(@PathVariable Long userID)
    {
        return ResponseEntity.ok(mealService.getAllMeals(userID));
    }

    @GetMapping("/{mealID}")
    public ResponseEntity<?> getMeal(@PathVariable Long mealID)
    {
        return ResponseEntity.ok(mealService.getMeal(mealID));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMeal(@PathVariable Long userID,
                                        @RequestBody MealTypeDto mealTypeDto)
    {
        MealDto mealDto = mealService.createMeal(userID, mealTypeDto);
        return new ResponseEntity<>(mealDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{mealID}/delete")
    public ResponseEntity<?> deleteMeal(@PathVariable Long mealID)
    {
        mealService.deleteMeal(mealID);
        return ResponseEntity.ok().body("");
    }
}
