package com.HowManyColories.HowManyColories.controllers;

import com.HowManyColories.HowManyColories.entities.DTOs.ProductItemDto;
import com.HowManyColories.HowManyColories.entities.DTOs.RecipeDto;
import com.HowManyColories.HowManyColories.services.ProductItemService;
import com.HowManyColories.HowManyColories.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping()
    public ResponseEntity<?> getProductItem()
    {
        return ResponseEntity.ok(recipeService.getAllRecipe());
    }

    @GetMapping("/{recipeID}")
    public ResponseEntity<?> getProductItem(@PathVariable Long recipeID)
    {
        return ResponseEntity.ok(recipeService.getRecipe(recipeID));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProductItem(@RequestBody RecipeDto RecipeDto)

    {
        RecipeDto createdRecipeDto= recipeService.createRecipe(RecipeDto);
        return new ResponseEntity<>(createdRecipeDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{recipeID}/update")
    public ResponseEntity<?> updateProductItem(@PathVariable Long recipeID,
                                               @RequestBody RecipeDto RecipeDto)
    {
        RecipeDto updatedProductItemDto = recipeService.updateRecipe(recipeID, RecipeDto);
        return new ResponseEntity<>(updatedProductItemDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{recipeID}/delete")
    public ResponseEntity<?> deleteProductItem(@PathVariable Long recipeID)
    {
        recipeService.deleteRecipe(recipeID);
        return ResponseEntity.ok().body("");
    }
}
