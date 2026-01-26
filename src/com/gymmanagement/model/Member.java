package com.gymmanagement.model;

import com.gymmanagement.exception.GymException;

public class Member extends Person {
    private String membershipType;

    // Конструктор
    public Member(int id, String name, int age, String membershipType) throws GymException {
        // super вызывает конструктор Person, где проходят проверки setId, setName, setAge
        super(id, name, age);
        this.membershipType = membershipType;
    }

    // Геттер для типа абонемента (нужен для MemberDAO)
    public String getMembershipType() {
        return membershipType;
    }

    // Сеттер для типа абонемента
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    @Override
    public void displayInfo() {
        // Мы используем getName() и getAge() из класса Person
        System.out.println("MEMBER [ID: " + id + " | Name: " + getName() +
                " | Age: " + getAge() + " | Type: " + membershipType + "]");
    }
}