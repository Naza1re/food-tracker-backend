package org.example.foodimporter.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodimporter.client.UsdaClient;
import org.example.foodimporter.dto.USDAFood;
import org.example.foodimporter.dto.USDANutrient;
import org.example.foodimporter.dto.USDAResponse;
import org.example.foodimporter.model.FoodProduct;
import org.example.foodimporter.repository.JpaFoodProductRepository;
import org.example.foodimporter.service.FoodImporterService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodImporterServiceImpl implements FoodImporterService {

    private final JpaFoodProductRepository productRepository;
    private final UsdaClient usdaClient;

    @Override
    public void importProducts(String query) {
        log.info("Start importProducts");
        USDAResponse response = usdaClient.searchFoods(query);

        if (response.getFoods() == null) return;

        for (USDAFood food : response.getFoods()) {
            FoodProduct product = new FoodProduct();
            product.setName(food.getDescription());

            for (USDANutrient nutrient : food.getFoodNutrients()) {
                switch (nutrient.getNutrientName()) {
                    case "Energy" -> product.setCalories(nutrient.getValue().intValue());
                    case "Protein" -> product.setProtein(nutrient.getValue());
                    case "Total lipid (fat)" -> product.setFat(nutrient.getValue());
                    case "Carbohydrate, by difference" -> product.setCarbs(nutrient.getValue());
                }
            }

            productRepository.save(product);
        }
        log.info("Finish importProducts");
    }
}
