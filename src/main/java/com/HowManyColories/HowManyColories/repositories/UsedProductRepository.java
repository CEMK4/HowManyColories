package com.HowManyColories.HowManyColories.repositories;

import com.HowManyColories.HowManyColories.entities.DTOs.UsedProductDto;
import com.HowManyColories.HowManyColories.entities.UsedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsedProductRepository extends JpaRepository<UsedProduct, Long> {
    List<UsedProductDto> findByMeal_Id(Long id);
}