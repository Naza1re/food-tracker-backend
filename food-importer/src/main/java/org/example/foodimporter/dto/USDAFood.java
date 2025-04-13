package org.example.foodimporter.dto;

import lombok.Data;

import java.util.List;

@Data
public class USDAFood {
    private String description;
    private List<USDANutrient> foodNutrients;
}
