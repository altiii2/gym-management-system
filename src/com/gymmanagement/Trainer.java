// Trainer.java - CHILD CLASS extends Person
public class Trainer extends Person {
    // Specific fields for Trainer
    private String specialization;
    private int experienceYears;
    private boolean isCertified;
    private double hourlyRate;

    // Constructor with super() call
    public Trainer(int trainerId, String name, String specialization,
                   int experienceYears, boolean isCertified, double hourlyRate) {
        super(trainerId, name, 25);  // Call parent constructor (default age 25)
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        setCertified(isCertified);
        setHourlyRate(hourlyRate);
    }

    // Default constructor
    public Trainer() {
        super(1, "Unknown Trainer", 25);
        this.specialization = "General Fitness";
        this.experienceYears = 0;
        this.isCertified = false;
        this.hourlyRate = 5000.0;
    }

    // Setters with validation
    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        } else {
            System.out.println("⚠️ Specialization cannot be empty! Setting to 'General Fitness'.");
            this.specialization = "General Fitness";
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0 && experienceYears <= 50) {
            this.experienceYears = experienceYears;
        } else {
            System.out.println("⚠️ Experience must be 0-50 years! Setting to 0.");
            this.experienceYears = 0;
        }
    }

    public void setCertified(boolean certified) {
        isCertified = certified;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.println("⚠️ Hourly rate cannot be negative! Setting to 5000.");
            this.hourlyRate = 5000.0;
        }
    }

    // Getters
    public int getTrainerId() { return id; }  // Inherited from Person
    public String getSpecialization() { return specialization; }
    public int getExperienceYears() { return experienceYears; }
    public boolean isCertified() { return isCertified; }
    public double getHourlyRate() { return hourlyRate; }

    // ==================== POLYMORPHISM: METHOD OVERRIDING ====================

    // Override parent's abstract method
    @Override
    public void displayInfo() {
        System.out.println("💪 TRAINER: " + name + " (ID: " + id + ")");
        System.out.println("   Specialization: " + specialization);
        System.out.println("   Experience: " + experienceYears + " years | Certified: " + (isCertified ? "✅" : "❌"));
        System.out.println("   Hourly Rate: " + hourlyRate + " KZT/hour");
    }

    // Override parent's method (different from Member)
    @Override
    public void introduce() {
        System.out.println("Hi! I'm trainer " + name + ".");
        System.out.println("I specialize in " + specialization + " with " + experienceYears + " years experience.");
    }

    // ==================== EXISTING METHODS (keep your business logic) ====================

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public double calculateSessionCost(int hours) {
        double cost = hourlyRate * hours;
        if (isCertified) {
            cost *= 1.1; // 10% extra for certified trainers
        }
        return cost;
    }

    public boolean canTrainMember(Member member) {
        return member.isActive() && member.getBalance() >= hourlyRate;
    }

    @Override
    public String toString() {
        return "Trainer{id=" + id + ", name='" + name + "', age=" + age +
                ", specialization='" + specialization + "', experienceYears=" + experienceYears +
                ", isCertified=" + isCertified + ", hourlyRate=" + hourlyRate + " KZT/hour}";
    }
}