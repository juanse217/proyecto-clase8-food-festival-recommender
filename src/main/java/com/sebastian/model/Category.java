package com.sebastian.model;

public enum Category {
    VEGAN("Vegan"), SWEET("Sweet"), SPICY("Spicy"), BEVERAGE("Beverage"),CLASSIC("CLassic");

    private String category;

    Category(String category){
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }

}
