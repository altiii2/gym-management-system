package com.gymmanagement;

import com.gymmanagement.menu.GymMenuManager;

public class Main {
    public static void main(String[] args) {
        // Создаем объект менеджера меню и запускаем его
        GymMenuManager menu = new GymMenuManager();
        menu.run();
    }
}