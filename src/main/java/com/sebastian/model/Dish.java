package com.sebastian.model;

public class Dish {
    private String name;  
    private double price; 
    private int calories;  
    private Category category;
    private Stand stand;
    public Dish(String name, double price, int calories, Category category, Stand stand) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.category = category;
        this.stand = stand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCalories() {
        return calories;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public Stand getStand() {
        return stand;
    }
    @Override
    public String toString() {
        return "Dish [name=" + name + ", price=" + price + ", calories=" + calories + ", category=" + category
                + ", stand=" + stand + "]";
    }

    
}
