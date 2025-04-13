package org.example.foodimporter.client;

import org.example.foodimporter.dto.USDAResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usdaClient", url = "${usda.base-url}")
public interface UsdaClient {

    @GetMapping("/foods/search")
    USDAResponse searchFoods(@RequestParam("query") String query);

}
