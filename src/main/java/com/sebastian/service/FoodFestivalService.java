package com.sebastian.service;

import com.sebastian.repository.memory.DishesMemoryImpl;

public class FoodFestivalService {

    private DishesMemoryImpl repo;

    public FoodFestivalService(DishesMemoryImpl repo){
        this.repo = repo;
    }
}
