package com.mateuszaksjonow.config;

import com.mateuszaksjonow.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.mateuszaksjonow")
@PropertySource("classpath:config/meal.properties")
public class AppConfig {

    @Value("${meal.burgerClassicName:Burger}")
    private String burgerClassicName;

    @Value("${meal.burgerClassicPrice:20}")
    private double burgerClassicPrice;

    @Value("${meal.burgerDoubleName:Burger}")
    private String burgerDoubleName;

    @Value("${meal.burgerDoublePrice:20}")
    private double burgerDoublePrice;

    @Value("${meal.burgerOnionName:Burger}")
    private String burgerOnionName;

    @Value("${meal.burgerOnionPrice:20}")
    private double burgerOnionPrice;

    @Value("${meal.burgerMexicanName:Burger}")
    private String burgerMexicanName;

    @Value("${meal.burgerMexicanPrice:20}")
    private double burgerMexicanPrice;

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

    @Bean
    @BurgerDoubleName
    public String burgerDoubleName() {
        return burgerDoubleName;
    }

    @Bean
    @BurgerDoublePrice
    public double burgerDoublePrice() {
        return burgerDoublePrice;
    }

    @Bean
    @BurgerOnionName
    public String burgerOnionName() {
        return burgerOnionName;
    }

    @Bean
    @BurgerOnionPrice
    public double burgerOnionPrice() {
        return burgerOnionPrice;
    }

    @Bean
    @BurgerMexicanName
    public String burgerMexicanName() {
        return burgerMexicanName;
    }

    @Bean
    @BurgerMexicanPrice
    public double burgerMexicanPrice() {
        return burgerMexicanPrice;
    }

}
