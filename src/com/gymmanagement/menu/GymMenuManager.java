package com.gymmanagement.menu;

import com.gymmanagement.model.*;
import com.gymmanagement.database.MemberDAO;
import com.gymmanagement.exception.GymException;
import java.util.ArrayList;
import java.util.Scanner;

public class GymMenuManager implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<WorkoutSession> sessions = new ArrayList<>();
    // Объект для работы с базой данных
    private MemberDAO memberDAO = new MemberDAO();

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
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            if (choice.equals("5")) {
                System.out.println("EXITING SYSTEM... ");
                break;
            }
            try {
                switch (choice) {
                    case "1" -> addMember();
                    case "2" -> addTrainer();
                    case "3" -> addWorkoutSession();
                    case "4" -> showAll();
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (GymException e) {
                System.out.println("SYSTEM ERROR: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: INVALID INPUT! Please enter a number.");
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

        // Создаем объект
        Member newMember = new Member(id, name, age, type);

        // Добавляем в локальный список (ArrayList)
        people.add(newMember);

        // ОТПРАВЛЯЕМ В БАЗУ ДАННЫХ (PostgreSQL)
        memberDAO.insertMember(newMember);

        System.out.println("✅ MEMBER ADDED SUCCESSFULLY TO LIST AND DATABASE");
    }

    private void addTrainer() throws GymException {
        System.out.print("ENTER ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("ENTER NAME: ");
        String name = scanner.nextLine();
        System.out.print("AGE: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("SPECIALIZATION TYPE: ");
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

    public void showAll() throws GymException {
        if (people.isEmpty()) {
            System.out.println("There are no people in the local system.");
        } else {
            System.out.println("\n--- LOCAL GYM RECORDS ---");
            for (Person p : people) {
                p.displayInfo();
            }
        }

        // ПОКАЗЫВАЕМ ДАННЫЕ НАПРЯМУЮ ИЗ ПОСТГРЕСА
        memberDAO.getAllMembers();
    }
}
