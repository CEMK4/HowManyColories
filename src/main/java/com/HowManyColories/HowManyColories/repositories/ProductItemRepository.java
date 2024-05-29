package com.HowManyColories.HowManyColories.repositories;

import com.HowManyColories.HowManyColories.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}