public class Member {
    // 1. PRIVATE FIELDS (minimum 4)
    private int memberId;
    private String name;
    private int age;
    private String membershipType;
    private boolean isActive;
    private double balance;

    // 2. CONSTRUCTOR WITH PARAMETERS (С ВАЛИДАЦИЕЙ)
    public Member(int memberId, String name, int age, String membershipType, boolean isActive, double balance) {
        setMemberId(memberId);
        setName(name);
        setAge(age);
        setMembershipType(membershipType);
        setActive(isActive);
        setBalance(balance);
    }

    // 3. DEFAULT CONSTRUCTOR (optional)
    public Member() {
        this.memberId = 1; // Используем валидацию через вызов сеттера
        this.name = "Unknown";
        this.age = 18;
        this.membershipType = "Basic";
        this.isActive = false;
        this.balance = 0.0;
    }

    // 4. GETTERS (оставляем ваши оригинальные)
    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getBalance() {
        return balance;
    }

    // 5. SETTERS (С ВАЛИДАЦИЕЙ - заменяем старые)
    public void setMemberId(int memberId) {
        if (memberId > 0) {
            this.memberId = memberId;
        } else {
            System.out.println("⚠️ Member ID must be positive! Setting to 1.");
            this.memberId = 1;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("⚠️ Name cannot be empty! Setting to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 16 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("⚠️ Age must be between 16 and 100! Setting to 18.");
            this.age = 18;
        }
    }

    public void setMembershipType(String membershipType) {
        if (membershipType.equals("Basic") || membershipType.equals("Premium") || membershipType.equals("Gold")) {
            this.membershipType = membershipType;
        } else {
            System.out.println("⚠️ Invalid membership type! Setting to 'Basic'.");
            this.membershipType = "Basic";
        }
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("⚠️ Balance cannot be negative! Setting to 0.");
            this.balance = 0;
        }
    }

    // 6. ADDITIONAL METHODS (оставляем ваши оригинальные)

    // Method 1: Upgrade membership
    public void upgradeMembership(String newType) {
        if (newType.equals("Premium") && balance >= 50000) {
            membershipType = newType;
            System.out.println(name + " upgraded to Premium membership!");
        } else if (newType.equals("Gold") && balance >= 30000) {
            membershipType = newType;
            System.out.println(name + " upgraded to Gold membership!");
        } else {
            System.out.println("Cannot upgrade. Insufficient balance or invalid type.");
        }
    }

    // Method 2: Check if member is eligible for discount
    public boolean isEligibleForDiscount() {
        return age < 25 || age > 60 || membershipType.equals("Premium");
    }

    // Method 3: Add workout session (extra method)
    public void addWorkoutSession(double sessionCost) {
        if (balance >= sessionCost) {
            balance -= sessionCost;
            System.out.println("Workout session added. New balance: " + balance + " KZT");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // 7. toString() METHOD (оставляем ваш оригинальный)
    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", membershipType='" + membershipType + '\'' +
                ", isActive=" + isActive +
                ", balance=" + balance + " KZT" +
                '}';
    }
}
