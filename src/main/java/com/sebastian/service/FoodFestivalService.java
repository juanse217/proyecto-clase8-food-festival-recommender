package com.sebastian.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sebastian.model.Dish;
import com.sebastian.repository.memory.DishesMemoryImpl;

public class FoodFestivalService {

    private DishesMemoryImpl repo;
    private List<Dish> dishes;

    public FoodFestivalService(DishesMemoryImpl repo){
        this.repo = repo; 
    }

    public List<Dish> filterByBudgetAndCategory(String category, double budget){
        dishes = repo.getAllDishes();
        return dishes.stream().filter(d -> d.getCategory().toString().equalsIgnoreCase(category) && d.getPrice() <= budget).sorted((d1, d2) -> Double.compare(d1.getPrice(), d2.getPrice())).toList();
    }

    public List<Dish> healthyTop3(){
        dishes = repo.getAllDishes();
        return dishes.stream().sorted((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories())).limit(3).toList();
    }

    public Map<String, List<Dish>> groupByCategory(){
        dishes = repo.getAllDishes();
        return dishes.stream().collect(Collectors.groupingBy(Dish::getCategory));
    }
}
