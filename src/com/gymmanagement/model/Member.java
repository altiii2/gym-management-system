package com.gymmanagement.model;

import com.gymmanagement.exception.GymException;

public class Member extends Person {
    private String membershipType;

    public Member(int id, String name, int age, String membershipType) throws GymException {
        super(id, name, age); // Вызывает конструктор Person, где идет проверка
        this.membershipType = membershipType;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + id + " | NAME: " + name + " | AGE: " + age + " | MEMBERSHIP: " + membershipType);
    }
}