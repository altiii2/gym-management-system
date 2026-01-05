// Person.java - PARENT CLASS for Member and Trainer
public abstract class Person {
    // Protected fields - accessible by child classes
    protected int id;
    protected String name;
    protected int age;

    // Constructor with validation
    public Person(int id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }

    // Validation in setters
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("⚠️ Person ID must be positive! Setting to 1.");
            this.id = 1;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("⚠️ Person name cannot be empty! Setting to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 16 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("⚠️ Person age must be 16-100! Setting to 18.");
            this.age = 18;
        }
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Abstract method - MUST be overridden by child classes
    public abstract void displayInfo();

    // Common method for all persons
    public void introduce() {
        System.out.println("Hello, I am " + name + ", age " + age);
    }
}