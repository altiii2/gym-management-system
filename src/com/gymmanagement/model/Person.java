package com.gymmanagement.model;

import com.gymmanagement.exception.GymException;

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) throws GymException {
        setId(id);
        setName(name);
        setAge(age);
    }

    public void setId(int id) throws GymException {
        if (id <= 0) throw new GymException("ID must be positive!");
        this.id = id;
    }

    public void setName(String name) throws GymException {
        if (name == null || name.trim().isEmpty()) throw new GymException("Name cannot be empty!");
        this.name = name;
    }

    public void setAge(int age) throws GymException {
        if (age < 16 || age > 100) throw new GymException("Age must be between 16 and 100!");
        this.age = age;
    }

    public String getName() { return name; }
    public abstract void displayInfo();
}