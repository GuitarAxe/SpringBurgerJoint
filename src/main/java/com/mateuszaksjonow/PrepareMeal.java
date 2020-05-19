package com.mateuszaksjonow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class PrepareMeal {

    Menu menu;

    @Autowired
    public PrepareMeal(Menu menu) {
        this.menu = menu;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {

        Scanner scanner = new Scanner(System.in);
        double charge = 0;

        menu.order(scanner);
    }
}
