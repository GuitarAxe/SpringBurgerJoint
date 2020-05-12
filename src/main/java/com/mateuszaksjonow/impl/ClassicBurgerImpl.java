package com.mateuszaksjonow.impl;

import com.mateuszaksjonow.annotations.BurgerClassicName;
import com.mateuszaksjonow.annotations.BurgerClassicPrice;
import com.mateuszaksjonow.api.Meal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ClassicBurgerImpl extends Meal {

    @Autowired
    public ClassicBurgerImpl(@BurgerClassicName String name, @BurgerClassicPrice double price) {
        super(name, price);
    }
}
