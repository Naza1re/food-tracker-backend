package org.example.foodimporter.repository;

import org.example.foodimporter.model.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFoodProductRepository extends JpaRepository<FoodProduct, Long>, JpaSpecificationExecutor<FoodProduct> {
}
