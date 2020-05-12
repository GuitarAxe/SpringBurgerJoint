package com.mateuszaksjonow;

import com.mateuszaksjonow.api.Meal;
import com.mateuszaksjonow.impl.ClassicBurgerImpl;
import com.mateuszaksjonow.impl.DoubleBurgerImpl;
import com.mateuszaksjonow.impl.MexicanBurgerImpl;
import com.mateuszaksjonow.impl.OnionBurgerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

    private List<Meal> orderList = new LinkedList<>();
    private List<Meal> burgerList = new LinkedList<>();

    DecimalFormat df = new DecimalFormat("#.##");

    private final ClassicBurgerImpl classicBurger;
    private final DoubleBurgerImpl doubleBurger;
    private final OnionBurgerImpl onionBurger;
    private final MexicanBurgerImpl mexicanBurger;


    @Autowired
    public Menu(ClassicBurgerImpl classicBurger, DoubleBurgerImpl doubleBurger, OnionBurgerImpl onionBurger, MexicanBurgerImpl mexicanBurger) {
        this.classicBurger = classicBurger;
        this.doubleBurger = doubleBurger;
        this.onionBurger = onionBurger;
        this.mexicanBurger = mexicanBurger;
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
                    "6. Order list, Remove meal \n" +
                    "7. Finish order");

            switch (entryInt(scanner.nextLine())) {
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
                    for (int i = 0; i < orderList.size(); i++) {
                        System.out.println(i + ": " + orderList.get(i).getName() + ": " + df.format(orderList.get(i).getPrice()) + "$.");
                    }
                    System.out.println("Total: " + totalPrice(orderList) + "$.");
                    break;
                case 7:
                    System.out.println("Total price: " + totalPrice(orderList) + "$.\n" +
                            "Bon appetite!");
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }


    }

    public List<Meal> burgerList(Scanner scanner) {
        burgerList.add(classicBurger);
        burgerList.add(doubleBurger);
        burgerList.add(onionBurger);
        burgerList.add(mexicanBurger);
        for (int i = 0; i < burgerList.size(); i++) {
            System.out.println(i+1 + ". " + burgerList.get(i).getName() + ": " + df.format(burgerList.get(i).getPrice()) + "$.");
        }
        System.out.println("0. Exit");

        boolean quit = false;
        while (!quit) {
            switch (entryInt(scanner.nextLine())) {
                case 1:
                    orderList.add(classicBurger);
                    break;
                case 2:
                    orderList.add(doubleBurger);
                    break;
                case 3:
                    orderList.add(onionBurger);
                    break;
                case 4:
                    orderList.add(mexicanBurger);
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong command!");
                    break;
            }
            System.out.println("Would you like to add something else?");
        }
        return orderList;
    }

    private int entryInt(String str) {
        int entry = 0;
        try {
            entry = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            System.out.println("Wrong input!");
        }
        return entry;
    }

    private String totalPrice(List<Meal> list) {
        double total = 0;
        for (Meal meal : list) {
            total+=meal.getPrice();
        }
        return df.format(total);
    }
}
