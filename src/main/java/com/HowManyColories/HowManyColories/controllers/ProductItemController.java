package com.HowManyColories.HowManyColories.controllers;


import com.HowManyColories.HowManyColories.entities.DTOs.MealTypeDto;
import com.HowManyColories.HowManyColories.entities.DTOs.ProductItemDto;
import com.HowManyColories.HowManyColories.services.MealTypeService;
import com.HowManyColories.HowManyColories.services.ProductItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-items")
@RequiredArgsConstructor
public class ProductItemController {
    private final ProductItemService productItemService;

    @GetMapping()
    public ResponseEntity<?> getProductItem()
    {
        return ResponseEntity.ok(productItemService.getAllProductItems());
    }

    @GetMapping("/{productItemID}")
    public ResponseEntity<?> getProductItem(@PathVariable Long productItemID)
    {
        return ResponseEntity.ok(productItemService.getProductItem(productItemID));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProductItem(@RequestBody ProductItemDto productItemDto)

    {
        ProductItemDto productItem= productItemService.createProductItem(productItemDto);
        return new ResponseEntity<>(productItemDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{productItemID}/update")
    public ResponseEntity<?> updateProductItem(@PathVariable Long productItemID,
                                               @RequestBody ProductItemDto productItemDto)
    {
        ProductItemDto updatedProductItemDto = productItemService.updateProductItem(productItemID, productItemDto);
        return new ResponseEntity<>(updatedProductItemDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productItemID}/delete")
    public ResponseEntity<?> deleteProductItem(@PathVariable Long productItemID)
    {
        productItemService.deleteProductItem(productItemID);
        return ResponseEntity.ok().body("");
    }
}
