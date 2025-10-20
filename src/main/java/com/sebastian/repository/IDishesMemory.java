package com.sebastian.repository;

import java.util.List;

import com.sebastian.exception.DishNotFoundException;
import com.sebastian.model.Dish;

public interface IDishesMemory {
    void addDish(Dish d);
    Dish consultDishByName(String name) throws DishNotFoundException;
    List<Dish> getAllDishes();
    void removeDishByName(String name) throws DishNotFoundException;
}
