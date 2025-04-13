package org.example.foodimporter.controller;

import lombok.RequiredArgsConstructor;
import org.example.foodimporter.service.FoodImporterService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/food-importer")
@RequiredArgsConstructor
public class FoodImporterController {

    private final FoodImporterService foodImporterService;

    @PutMapping("/import/{query}")
    public void importFood(@PathVariable String query) {
        foodImporterService.importProducts(query);
    }
}
