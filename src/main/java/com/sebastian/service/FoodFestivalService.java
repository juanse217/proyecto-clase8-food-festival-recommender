package com.sebastian.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sebastian.model.Dish;
import com.sebastian.repository.IDishesMemory;
import com.sebastian.repository.memory.DishesMemoryImpl;

public class FoodFestivalService {

    //We use the INterface for good practices. 
    /*
        All constructor-injected dependencies should be final unless you have a very strong reason not to.

        We use final so we ensure it's immutable. We can't change the reference but we can still change the internal data. 
     */
    private final IDishesMemory repo;
    private List<Dish> dishes; //Having a List is not a good Idea, Because it means the Service has state. The Services are stateless. The best we can do is create local variables using repo.getAllDishes().

    /*
    // Services should be stateless. 
    // Storing mutable data (like a List fetched from a repository) as a field
    // introduces state into the Service.
    // Instead, repositories should be called inside methods
    // and their results stored in local variables. 
 */

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
