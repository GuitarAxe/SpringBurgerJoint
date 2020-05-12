package com.mateuszaksjonow.config;

import com.mateuszaksjonow.annotations.BurgerClassicName;
import com.mateuszaksjonow.annotations.BurgerClassicPrice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.mateuszaksjonow")
@PropertySource("classpath:config/meal.properties")
public class AppConfig {

    @Value("${meal.burgerClassicName:Burger Classic}")
    private String burgerClassicName;

    @Value("${meal.burgerClassicPrice:20}")
    private double burgerClassicPrice;

    @Bean
    @BurgerClassicName
    public String burgerClassicName() {
        return burgerClassicName;
    }

    @Bean
    @BurgerClassicPrice
    public double burgerClassicPrice() {
        return burgerClassicPrice;
    }

}
