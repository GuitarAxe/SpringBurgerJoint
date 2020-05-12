package com.mateuszaksjonow;

import com.mateuszaksjonow.api.Meal;
import com.mateuszaksjonow.impl.ClassicBurgerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

    private List<Meal> orderList = new LinkedList<>();

    private final ClassicBurgerImpl classicBurger;

    @Autowired
    public Menu(ClassicBurgerImpl classicBurger) {
        this.classicBurger = classicBurger;
    }

    public void order(Scanner scanner) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Welcome! Please make your order: \n" +
                    "1. Choose burger \n" +
                    "2. Choose another meal \n" +
                    "3. Choose additional foods \n" +
                    "4. Choose drink \n" +
                    "5. Make your own burger \n" +
                    "6. Order list \n" +
                    "7. Finish order");

            switch (entryInt(scanner)) {
                case 1:
                    burgerList(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    for (Meal meal : orderList) {
                        System.out.println("1: " + meal.getName() + ": " + meal.getPrice());
                    }
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }


    }

    public List burgerList(Scanner scanner) {
        System.out.println("1. Classic burger: 16.90 \n" +
                "2. Exit");

        boolean quit = false;
        while (!quit) {
            switch (entryInt(scanner)) {
                case 1:
                    orderList.add(classicBurger);
                    break;
                case 2:
                    quit = true;
                    break;
            }
        }
        return orderList;
    }

    private int entryInt(Scanner scanner) {
        int entry = 0;
        try {
            entry = scanner.nextInt();
            scanner.nextLine();
        }catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return entry;
    }
}
