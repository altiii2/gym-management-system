package com.gymmanagement.menu;

import com.gymmanagement.interfaces.Menu;
import com.gymmanagement.model.*;
import com.gymmanagement.exception.GymException; // Исправлено имя импорта
import java.util.ArrayList;
import java.util.Scanner;

public class GymMenuManager implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<WorkoutSession> sessions = new ArrayList<>();

    @Override
    public void displayMenu() {
        System.out.println("\n===== GYM MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Member");
        System.out.println("2. Add Trainer");
        System.out.println("3. Add Workout Session");
        System.out.println("4. Show All Records");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    @Override
    public void run() {
        while(true) {
            displayMenu();
            String choice = scanner.nextLine();
            if(choice.equals("5")) {
                System.out.println("EXITING SYSTEM...");
                break;
            }
            try {
                switch (choice) {
                    case "1" -> addMember();
                    case "2" -> addTrainer();
                    case "3" -> addWorkoutSession();
                    case "4" -> showAll();
                    default -> System.out.println("INVALID CHOICE");
                }
            } catch (GymException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("INPUT ERROR: Please enter a valid number!");
            }
        }
    }

    private void addMember() throws GymException {
        System.out.print("ENTER ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("ENTER NAME: ");
        String name = scanner.nextLine();
        System.out.print("AGE: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("MEMBERSHIP TYPE: ");
        String type = scanner.nextLine();

        people.add(new Member(id, name, age, type));
        System.out.println("✅ MEMBER ADDED SUCCESSFULLY");
    }

    private void addTrainer() throws GymException {
        System.out.print("ENTER ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("ENTER NAME: ");
        String name = scanner.nextLine();
        System.out.print("AGE: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("SPECIALIZATION: ");
        String spec = scanner.nextLine();

        people.add(new Trainer(id, name, age, spec));
        System.out.println("✅ TRAINER ADDED SUCCESSFULLY");
    }

    private void addWorkoutSession() throws GymException {
        System.out.print("Session ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Member Name: ");
        String mName = scanner.nextLine();
        System.out.print("Trainer Name: ");
        String tName = scanner.nextLine();
        System.out.print("Duration (min): ");
        int duration = Integer.parseInt(scanner.nextLine());

        sessions.add(new WorkoutSession(id, mName, tName, duration, "General", false));
        System.out.println("✅ Session scheduled!");
    }

    public void showAll() {
        if (people.isEmpty()) {
            System.out.println("LIST IS EMPTY");
        } else {
            System.out.println("--- GYM RECORDS ---");
            for (Person p : people) {
                p.displayInfo();
            }
        }
    }
}