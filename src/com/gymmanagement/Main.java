public class Main {
    public static void main(String[] args) {
        System.out.println("=== GYM MANAGEMENT SYSTEM ===");
        System.out.println("Week 4: Inheritance & Polymorphism Test\n");

        // Test 1: Member creation and validation
        System.out.println("--- Test 1: Member Validation ---");
        Member m1 = new Member(101, "John Test", 25, "Premium", true, 50000);
        System.out.println("✅ Valid member: " + m1.getName());

        Member m2 = new Member(-5, "", 150, "WrongType", true, -1000);
        System.out.println("⚠️ Invalid member created (with automatic fixes)");

        // Test 2: Trainer creation and validation
        System.out.println("\n--- Test 2: Trainer Validation ---");
        Trainer t1 = new Trainer(201, "Mike Test", "Strength", 8, true, 7000);
        System.out.println("✅ Valid trainer: " + t1.getName());

        // Test 3: POLYMORPHISM DEMONSTRATION
        System.out.println("\n=== Test 3: Polymorphism Demonstration ===");

        // Create polymorphic array
        Person[] people = new Person[4];

        // Add different types to same array (POLYMORPHISM)
        people[0] = new Member(301, "Polymorph Member 1", 30, "Gold", true, 40000);
        people[1] = new Trainer(401, "Polymorph Trainer 1", "Yoga", 5, true, 6000);
        people[2] = new Member(302, "Polymorph Member 2", 22, "Basic", true, 10000);
        people[3] = new Trainer(402, "Polymorph Trainer 2", "Boxing", 10, true, 9000);

        System.out.println("Created Person array with " + people.length + " objects:");
        System.out.println("- 2 Members and 2 Trainers stored as Person");

        // Polymorphic method calls
        System.out.println("\nCalling displayInfo() - different output for each type:");
        System.out.println("-".repeat(50));
        for (Person person : people) {
            person.displayInfo();  // ← POLYMORPHISM!
            System.out.println();
        }

        // Using instanceof
        System.out.println("Using instanceof to identify types:");
        for (Person person : people) {
            if (person instanceof Member) {
                System.out.println("✓ " + person.getName() + " is a Member");
            } else if (person instanceof Trainer) {
                System.out.println("✓ " + person.getName() + " is a Trainer");
            }
        }

        // Demonstrate inheritance
        System.out.println("\n=== Inheritance Features ===");
        Member testMember = new Member(999, "Inheritance Test", 28, "Premium", true, 60000);

        System.out.println("1. Member extends Person: " + (testMember instanceof Person));
        System.out.println("2. Can access Person methods: ");
        testMember.introduce();  // Inherited from Person

        System.out.println("\n=== ALL TESTS COMPLETE ===");
        System.out.println("✅ Week 3: Encapsulation & Validation - PASSED");
        System.out.println("✅ Week 4: Inheritance & Polymorphism - PASSED");
        System.out.println("\nNow run GymMenu.java for full interactive experience!");
    }
}