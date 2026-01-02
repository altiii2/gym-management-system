public class Trainer {
    // 1. PRIVATE FIELDS (minimum 4)
    private int trainerId;
    private String name;
    private String specialization;
    private int experienceYears;
    private boolean isCertified;
    private double hourlyRate;

    // 2. CONSTRUCTOR WITH PARAMETERS (С ВАЛИДАЦИЕЙ)
    public Trainer(int trainerId, String name, String specialization, int experienceYears, boolean isCertified, double hourlyRate) {
        setTrainerId(trainerId);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        setCertified(isCertified);
        setHourlyRate(hourlyRate);
    }

    // 3. DEFAULT CONSTRUCTOR
    public Trainer() {
        this.trainerId = 1;
        this.name = "Unknown Trainer";
        this.specialization = "General Fitness";
        this.experienceYears = 0;
        this.isCertified = false;
        this.hourlyRate = 5000.0;
    }

    // 4. GETTERS (оставляем без изменений)
    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public boolean isCertified() {
        return isCertified;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    // 5. SETTERS (ДОБАВЛЯЕМ ВАЛИДАЦИЮ)

    public void setTrainerId(int trainerId) {
        if (trainerId > 0) {
            this.trainerId = trainerId;
        } else {
            System.out.println("⚠️ Trainer ID must be positive! Setting to 1.");
            this.trainerId = 1;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("⚠️ Trainer name cannot be empty! Setting to 'Unknown Trainer'.");
            this.name = "Unknown Trainer";
        }
    }

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
            System.out.println("⚠️ Experience years must be 0-50! Setting to 0.");
            this.experienceYears = 0;
        }
    }

    public void setCertified(boolean certified) {
        isCertified = certified; // boolean не требует валидации
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.println("⚠️ Hourly rate cannot be negative! Setting to 5000.");
            this.hourlyRate = 5000.0;
        }
    }

    // 6. ADDITIONAL METHODS (оставляем без изменений)

    // Method 1: Check if trainer is experienced
    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    // Method 2: Calculate session cost
    public double calculateSessionCost(int hours) {
        double cost = hourlyRate * hours;
        if (isCertified) {
            cost *= 1.1; // 10% extra for certified trainers
        }
        return cost;
    }

    // Method 3: Check if trainer can train a specific member (extra)
    public boolean canTrainMember(Member member) {
        return member.isActive() && member.getBalance() >= hourlyRate;
    }

    // 7. toString() METHOD (оставляем без изменений)
    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                ", isCertified=" + isCertified +
                ", hourlyRate=" + hourlyRate + " KZT/hour" +
                '}';
    }
}