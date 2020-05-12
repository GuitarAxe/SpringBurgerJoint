package com.mateuszaksjonow.impl;

import com.mateuszaksjonow.annotations.BurgerClassicName;
import com.mateuszaksjonow.annotations.BurgerClassicPrice;
import com.mateuszaksjonow.api.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassicBurgerImpl extends Meal {

    @Autowired
    public ClassicBurgerImpl(@BurgerClassicName String name, @BurgerClassicPrice double price) {
        super(name, price);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }
}
