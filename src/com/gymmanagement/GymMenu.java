import java.util.ArrayList;
import java.util.Scanner;

public class GymMenu {
    // POLYMORPHIC ArrayList for inheritance demonstration
    private static ArrayList<Person> allPeople = new ArrayList<>();  // ← POLYMORPHISM!

    // Regular ArrayLists for specific types
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static ArrayList<WorkoutSession> sessions = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== GYM MANAGEMENT SYSTEM ===");
        System.out.println("Week 4: Inheritance & Polymorphism\n");

        // Add test data
        addTestData();

        // Main menu loop
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> addMember();
                case 2 -> viewAllMembers();
                case 3 -> addTrainer();
                case 4 -> viewAllTrainers();
                case 5 -> addWorkoutSession();
                case 6 -> viewAllSessions();
                case 7 -> demonstratePolymorphism();  // ← NEW: POLYMORPHISM DEMO
                case 8 -> {
                    System.out.println("\nThank you for using Gym Management System!");
                    System.out.println("Goodbye! 👋");
                    running = false;
                }
                default -> System.out.println("❌ Invalid choice! Please try again.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    // ==================== MENU METHODS ====================

    private static void displayMainMenu() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("       GYM MANAGEMENT MENU (Week 4)");
        System.out.println("═".repeat(50));
        System.out.println("1. ➕ Add New Member");
        System.out.println("2. 👥 View All Members");
        System.out.println("3. ➕ Add New Trainer");
        System.out.println("4. 👥 View All Trainers");
        System.out.println("5. ➕ Add New Workout Session");
        System.out.println("6. 👥 View All Workout Sessions");
        System.out.println("7. 🎭 Demonstrate Polymorphism");  // ← NEW OPTION
        System.out.println("8. 🚪 Exit");
        System.out.println("═".repeat(50));
    }

    // ==================== TEST DATA ====================

    private static void addTestData() {
        // Create objects
        Member m1 = new Member(101, "John Doe", 25, "Premium", true, 75000);
        Member m2 = new Member(102, "Alice Smith", 19, "Basic", true, 15000);
        Member m3 = new Member(103, "Bob Johnson", 45, "Gold", true, 35000);

        Trainer t1 = new Trainer(201, "Mike Tyson", "Boxing", 15, true, 10000);
        Trainer t2 = new Trainer(202, "Anna Yoga", "Yoga & Meditation", 8, true, 7000);

        // Add to regular lists
        members.add(m1); members.add(m2); members.add(m3);
        trainers.add(t1); trainers.add(t2);

        // ADD TO POLYMORPHIC LIST (most important for Week 4!)
        allPeople.add(m1);  // Member IS-A Person (polymorphism)
        allPeople.add(m2);  // Member IS-A Person
        allPeople.add(m3);  // Member IS-A Person
        allPeople.add(t1);  // Trainer IS-A Person (polymorphism)
        allPeople.add(t2);  // Trainer IS-A Person

        sessions.add(new WorkoutSession(301, "John Doe", "Mike Tyson", 90, "Boxing", false));
        sessions.add(new WorkoutSession(302, "Alice Smith", "Anna Yoga", 60, "Yoga", true));

        System.out.println("✅ Test data loaded successfully!");
        System.out.println("   Total people in polymorphic list: " + allPeople.size());
    }

    // ==================== POLYMORPHISM DEMONSTRATION ====================

    private static void demonstratePolymorphism() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("         POLYMORPHISM DEMONSTRATION");
        System.out.println("═".repeat(60));

        if (allPeople.isEmpty()) {
            System.out.println("No people found.");
            return;
        }

        System.out.println("This ArrayList<Person> contains " + allPeople.size() + " objects:");
        System.out.println("- Members and Trainers stored together as Person");
        System.out.println("- Each object keeps its actual type at runtime");
        System.out.println("");

        // 1. POLYMORPHIC METHOD CALLS
        System.out.println("=== 1. Polymorphic Method Calls (displayInfo()) ===");
        System.out.println("Same method call, different behavior:");
        System.out.println("-".repeat(40));

        for (Person person : allPeople) {
            person.displayInfo();  // ← POLYMORPHISM: calls correct version
            System.out.println();
        }

        // 2. USING INSTANCEOF AND CASTING
        System.out.println("=== 2. Using instanceof and Type Casting ===");
        int memberCount = 0, trainerCount = 0;

        for (Person person : allPeople) {
            if (person instanceof Member) {
                memberCount++;
                Member m = (Member) person;  // Safe casting after instanceof
                System.out.println("✓ " + m.getName() + " is a Member");
                System.out.println("  Can call Member-specific method: getBalance() = " + m.getBalance() + " KZT");
            } else if (person instanceof Trainer) {
                trainerCount++;
                Trainer t = (Trainer) person;  // Safe casting after instanceof
                System.out.println("✓ " + t.getName() + " is a Trainer");
                System.out.println("  Can call Trainer-specific method: getSpecialization() = " + t.getSpecialization());
            }
        }

        System.out.println("\nSummary: " + memberCount + " Members, " + trainerCount + " Trainers");

        // 3. DEMONSTRATE INHERITANCE STRUCTURE
        System.out.println("\n=== 3. Inheritance Structure ===");
        System.out.println("Person (Parent)");
        System.out.println("├── Member (Child)");
        System.out.println("└── Trainer (Child)");
        System.out.println("");
        System.out.println("Both use super() in constructors:");
        System.out.println("- Member: super(id, name, age)");
        System.out.println("- Trainer: super(id, name, 25)");

        System.out.println("\n" + "═".repeat(60));
        System.out.println("✅ Polymorphism demonstration complete!");
    }

    // ==================== HELPER METHODS ====================

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        int value = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return value;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        double value = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        return value;
    }

    // ==================== MEMBER METHODS ====================

    private static void addMember() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("           ADD NEW MEMBER");
        System.out.println("─".repeat(40));

        int id = getIntInput("Member ID: ");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        int age = getIntInput("Age: ");
        System.out.print("Membership Type (Basic/Gold/Premium): ");
        String type = scanner.nextLine();
        System.out.print("Is active? (true/false): ");
        boolean active = scanner.nextBoolean();
        scanner.nextLine();
        double balance = getDoubleInput("Balance (KZT): ");

        Member member = new Member(id, name, age, type, active, balance);
        members.add(member);
        allPeople.add(member);  // Also add to polymorphic list

        System.out.println("\n✅ Member added successfully!");
        System.out.println("   Name: " + member.getName());
        System.out.println("   Type: " + member.getMembershipType());
        System.out.println("   Balance: " + member.getBalance() + " KZT");
    }

    private static void viewAllMembers() {
        System.out.println("\n" + "─".repeat(60));
        System.out.println("                    ALL MEMBERS");
        System.out.println("─".repeat(60));

        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        System.out.printf("Total members: %d\n\n", members.size());
        System.out.printf("%-3s %-6s %-20s %-5s %-10s %-8s %-12s\n",
                "No.", "ID", "Name", "Age", "Type", "Active", "Balance");
        System.out.println("─".repeat(60));

        for (int i = 0; i < members.size(); i++) {
            Member m = members.get(i);
            System.out.printf("%-3d %-6d %-20s %-5d %-10s %-8s %-12.2f\n",
                    i + 1,
                    m.getMemberId(),
                    m.getName(),
                    m.getAge(),
                    m.getMembershipType(),
                    m.isActive() ? "✅" : "❌",
                    m.getBalance());
        }
        System.out.println("─".repeat(60));
    }

    // ==================== TRAINER METHODS ====================

    private static void addTrainer() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("           ADD NEW TRAINER");
        System.out.println("─".repeat(40));

        int id = getIntInput("Trainer ID: ");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();
        int experience = getIntInput("Experience (years): ");
        System.out.print("Is certified? (true/false): ");
        boolean certified = scanner.nextBoolean();
        scanner.nextLine();
        double rate = getDoubleInput("Hourly rate (KZT): ");

        Trainer trainer = new Trainer(id, name, specialization, experience, certified, rate);
        trainers.add(trainer);
        allPeople.add(trainer);  // Also add to polymorphic list

        System.out.println("\n✅ Trainer added successfully!");
        System.out.println("   Name: " + trainer.getName());
        System.out.println("   Specialization: " + trainer.getSpecialization());
        System.out.println("   Experience: " + trainer.getExperienceYears() + " years");
    }

    private static void viewAllTrainers() {
        System.out.println("\n" + "─".repeat(70));
        System.out.println("                     ALL TRAINERS");
        System.out.println("─".repeat(70));

        if (trainers.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }

        System.out.printf("Total trainers: %d\n\n", trainers.size());
        System.out.printf("%-3s %-6s %-20s %-20s %-5s %-10s %-12s\n",
                "No.", "ID", "Name", "Specialization", "Exp", "Certified", "Rate/hour");
        System.out.println("─".repeat(70));

        for (int i = 0; i < trainers.size(); i++) {
            Trainer t = trainers.get(i);
            System.out.printf("%-3d %-6d %-20s %-20s %-5d %-10s %-12.2f\n",
                    i + 1,
                    t.getTrainerId(),
                    t.getName(),
                    t.getSpecialization(),
                    t.getExperienceYears(),
                    t.isCertified() ? "✅" : "❌",
                    t.getHourlyRate());
        }
        System.out.println("─".repeat(70));
    }

    // ==================== SESSION METHODS ====================

    private static void addWorkoutSession() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("       ADD NEW WORKOUT SESSION");
        System.out.println("─".repeat(40));

        int id = getIntInput("Session ID: ");
        System.out.print("Member Name: ");
        String memberName = scanner.nextLine();
        System.out.print("Trainer Name: ");
        String trainerName = scanner.nextLine();
        int duration = getIntInput("Duration (minutes): ");
        System.out.print("Session Type: ");
        String type = scanner.nextLine();
        System.out.print("Is completed? (true/false): ");
        boolean completed = scanner.nextBoolean();
        scanner.nextLine();

        WorkoutSession session = new WorkoutSession(id, memberName, trainerName, duration, type, completed);
        sessions.add(session);

        System.out.println("\n✅ Workout session added successfully!");
        System.out.println("   Session ID: " + session.getSessionId());
        System.out.println("   Member: " + session.getMemberName());
        System.out.println("   Trainer: " + session.getTrainerName());
        System.out.println("   Duration: " + session.getDurationMinutes() + " min");
    }

    private static void viewAllSessions() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("                  ALL WORKOUT SESSIONS");
        System.out.println("─".repeat(80));

        if (sessions.isEmpty()) {
            System.out.println("No sessions found.");
            return;
        }

        System.out.printf("Total sessions: %d\n\n", sessions.size());
        System.out.printf("%-3s %-6s %-20s %-20s %-8s %-15s %-10s\n",
                "No.", "ID", "Member", "Trainer", "Duration", "Type", "Completed");
        System.out.println("─".repeat(80));

        for (int i = 0; i < sessions.size(); i++) {
            WorkoutSession s = sessions.get(i);
            System.out.printf("%-3d %-6d %-20s %-20s %-8d %-15s %-10s\n",
                    i + 1,
                    s.getSessionId(),
                    s.getMemberName(),
                    s.getTrainerName(),
                    s.getDurationMinutes(),
                    s.getSessionType(),
                    s.isCompleted() ? "✅" : "⏳");
        }
        System.out.println("─".repeat(80));
    }
}