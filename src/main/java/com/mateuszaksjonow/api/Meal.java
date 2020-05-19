package com.mateuszaksjonow.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Meal {

    private String name;
    private double price;

    public Meal(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
