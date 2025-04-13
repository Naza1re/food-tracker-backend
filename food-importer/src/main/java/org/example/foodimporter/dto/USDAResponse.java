package org.example.foodimporter.dto;

import lombok.Data;

import java.util.List;

@Data
public class USDAResponse {
    private List<USDAFood> foods;
}
