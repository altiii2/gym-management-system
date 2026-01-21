package com.gymmanagement.model;

import com.gymmanagement.exception.GymException;

public class Trainer extends Person {
    private String specialization;

    // Конструктор должен совпадать с вызовом в GymMenuManager
    public Trainer(int id, String name, int age, String specialization) throws GymException {
        super(id, name, age); // Валидация ID, имени и возраста происходит в Person
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        System.out.println("🆔 TRAINER ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Spec: " + specialization);
    }

    public String getSpecialization() {
        return specialization;
    }
}