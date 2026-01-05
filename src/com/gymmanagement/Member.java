// Member.java - CHILD CLASS extends Person
public class Member extends Person {
    // Specific fields for Member
    private String membershipType;
    private boolean isActive;
    private double balance;

    // Constructor with super() call
    public Member(int memberId, String name, int age,
                  String membershipType, boolean isActive, double balance) {
        super(memberId, name, age);  // Call parent constructor
        setMembershipType(membershipType);
        setActive(isActive);
        setBalance(balance);
    }

    // Default constructor
    public Member() {
        super(1, "Unknown Member", 18);  // Default values
        this.membershipType = "Basic";
        this.isActive = false;
        this.balance = 0.0;
    }

    // Setters with validation
    public void setMembershipType(String membershipType) {
        if (membershipType.equals("Basic") || membershipType.equals("Gold") || membershipType.equals("Premium")) {
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

    // Getters
    public int getMemberId() { return id; }  // Inherited from Person
    public String getMembershipType() { return membershipType; }
    public boolean isActive() { return isActive; }
    public double getBalance() { return balance; }

    // ==================== POLYMORPHISM: METHOD OVERRIDING ====================

    // Override parent's abstract method
    @Override
    public void displayInfo() {
        System.out.println("🏋️‍♂️ MEMBER: " + name + " (ID: " + id + ")");
        System.out.println("   Age: " + age + " | Membership: " + membershipType);
        System.out.println("   Active: " + (isActive ? "✅" : "❌") + " | Balance: " + balance + " KZT");
    }

    // Override parent's method with super() call
    @Override
    public void introduce() {
        super.introduce();  // Call parent's introduce() first
        System.out.println("I have " + membershipType + " membership.");
    }

    // ==================== EXISTING METHODS (keep your business logic) ====================

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

    public boolean isEligibleForDiscount() {
        return age < 25 || age > 60 || membershipType.equals("Premium");
    }

    public void addWorkoutSession(double sessionCost) {
        if (balance >= sessionCost) {
            balance -= sessionCost;
            System.out.println("Workout session added. New balance: " + balance + " KZT");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public String toString() {
        return "Member{id=" + id + ", name='" + name + "', age=" + age +
                ", membershipType='" + membershipType + "', isActive=" + isActive +
                ", balance=" + balance + " KZT}";
    }
}