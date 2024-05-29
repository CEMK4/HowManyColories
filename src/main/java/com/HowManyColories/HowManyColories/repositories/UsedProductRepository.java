package com.HowManyColories.HowManyColories.repositories;

import com.HowManyColories.HowManyColories.entities.UsedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedProductRepository extends JpaRepository<UsedProduct, Long> {
}