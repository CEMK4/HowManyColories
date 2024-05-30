package com.HowManyColories.HowManyColories.controllers;

import com.HowManyColories.HowManyColories.entities.DTOs.ProductItemDto;
import com.HowManyColories.HowManyColories.entities.DTOs.RecipeDto;
import com.HowManyColories.HowManyColories.entities.DTOs.UsedProductDto;
import com.HowManyColories.HowManyColories.services.RecipeService;
import com.HowManyColories.HowManyColories.services.UsedProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/{userID}/meals/{mealID}/used-products")
@RequiredArgsConstructor
public class UsedProductController {
    private final UsedProductService usedProductService;

    @GetMapping()
    public ResponseEntity<?> getAllUsedProduct(@PathVariable("mealID") Long mealID)
    {
        return ResponseEntity.ok(usedProductService.getAllUsedProduct(mealID));
    }

    @GetMapping("/{usedProductID}")
    public ResponseEntity<?> getUsedProduct(@PathVariable Long usedProductID)
    {
        return ResponseEntity.ok(usedProductService.getUsedProduct(usedProductID));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUsedProduct(@PathVariable("mealID") Long mealID,
                                               @RequestBody UsedProductDto usedProductDto)

    {
        UsedProductDto createdUsedProductDto= usedProductService.createUsedProduct(mealID, usedProductDto);
        return new ResponseEntity<>(createdUsedProductDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{usedProductID}/update")
    public ResponseEntity<?> updateUsedProduct(@PathVariable Long usedProductID,
                                               @RequestBody UsedProductDto usedProductDto)
    {
        UsedProductDto updatedUsedProductDto = usedProductService.updateUsedProduct(usedProductID, usedProductDto);
        return new ResponseEntity<>(updatedUsedProductDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{usedProductID}/delete")
    public ResponseEntity<?> deleteUsedProduct(@PathVariable Long usedProductID)
    {
        usedProductService.deleteUsedProduct(usedProductID);
        return ResponseEntity.ok().body("");
    }
}
