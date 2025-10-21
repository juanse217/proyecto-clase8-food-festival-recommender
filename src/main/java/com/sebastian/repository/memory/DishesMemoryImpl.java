package com.sebastian.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.sebastian.exception.DishNotFoundException;
import com.sebastian.model.Dish;
import com.sebastian.repository.IDishesMemory;

public class DishesMemoryImpl implements IDishesMemory {

    private List<Dish> dishes;

    public DishesMemoryImpl(){
        dishes = new ArrayList<>();
    }

    @Override
    public void addDish(Dish d) {
        dishes.add(d);
    }

    @Override
    public Dish consultDishByCategory(String category) throws DishNotFoundException{
        return dishes.stream().filter(d -> d.getCategory().toString().equals(category)).findFirst().orElseThrow(() -> new DishNotFoundException("The dish couldn't be found") );
    }

    @Override
    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishes);
    }

    @Override
    public void removeDishByName(String name) throws DishNotFoundException{
        dishes.remove(dishes.stream().filter(d -> d.getName().equals(name)).findFirst().orElseThrow(() -> new DishNotFoundException("Dish Not found for deletion")));
    }
    
}
