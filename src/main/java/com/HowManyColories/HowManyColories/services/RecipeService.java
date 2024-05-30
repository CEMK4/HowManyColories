package com.HowManyColories.HowManyColories.services;

import com.HowManyColories.HowManyColories.entities.DTOs.ProductItemDto;
import com.HowManyColories.HowManyColories.entities.DTOs.RecipeDto;
import com.HowManyColories.HowManyColories.entities.ProductItem;
import com.HowManyColories.HowManyColories.entities.Recipe;
import com.HowManyColories.HowManyColories.repositories.ProductItemRepository;
import com.HowManyColories.HowManyColories.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final ProductItemRepository productItemRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipe(Long recipeID) {
        return recipeRepository.findById(recipeID).get();
    }

    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeDto.getTitle());
        List<ProductItem> productItems = productItemRepository.findAllById(recipeDto.getProductItemIds());
        recipe.setProductItems(productItems);
        recipe = recipeRepository.save(recipe);
        return new RecipeDto(recipe.getId(), recipe.getTitle(),
                recipe.getProductItems().stream().map(ProductItem::getId).collect(Collectors.toList()));
    }

    public RecipeDto updateRecipe(Long recipeID, RecipeDto recipeDto) {
        Optional<Recipe> recipeOpt = recipeRepository.findById(recipeID);
        if (recipeOpt.isPresent()) {
            Recipe recipe = recipeOpt.get();
            recipe.setTitle(recipeDto.getTitle());
            List<ProductItem> productItems = productItemRepository.findAllById(recipeDto.getProductItemIds());
            recipe.setProductItems(productItems);
            recipe = recipeRepository.save(recipe);
            return new RecipeDto(recipe.getId(), recipe.getTitle(),
                    recipe.getProductItems().stream().map(ProductItem::getId).collect(Collectors.toList()));
        }
        return null; 
    }

    public void deleteRecipe(Long recipeID) {
        recipeRepository.deleteById(recipeID);
    }
}
