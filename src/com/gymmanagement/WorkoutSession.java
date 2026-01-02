public class WorkoutSession {
    // 1. PRIVATE FIELDS (minimum 4)
    private int sessionId;
    private String memberName;
    private String trainerName;
    private int durationMinutes;
    private String sessionType;
    private boolean isCompleted;

    // 2. CONSTRUCTOR WITH PARAMETERS (С ВАЛИДАЦИЕЙ)
    public WorkoutSession(int sessionId, String memberName, String trainerName, int durationMinutes, String sessionType, boolean isCompleted) {
        setSessionId(sessionId);
        setMemberName(memberName);
        setTrainerName(trainerName);
        setDurationMinutes(durationMinutes);
        setSessionType(sessionType);
        setCompleted(isCompleted);
    }

    // 3. DEFAULT CONSTRUCTOR
    public WorkoutSession() {
        this.sessionId = 1;
        this.memberName = "Unknown Member";
        this.trainerName = "Unknown Trainer";
        this.durationMinutes = 60;
        this.sessionType = "General Training";
        this.isCompleted = false;
    }

    // 4. GETTERS (оставляем без изменений)
    public int getSessionId() {
        return sessionId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getSessionType() {
        return sessionType;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // 5. SETTERS (ДОБАВЛЯЕМ ВАЛИДАЦИЮ)

    public void setSessionId(int sessionId) {
        if (sessionId > 0) {
            this.sessionId = sessionId;
        } else {
            System.out.println("⚠️ Session ID must be positive! Setting to 1.");
            this.sessionId = 1;
        }
    }

    public void setMemberName(String memberName) {
        if (memberName != null && !memberName.trim().isEmpty()) {
            this.memberName = memberName;
        } else {
            System.out.println("⚠️ Member name cannot be empty! Setting to 'Unknown Member'.");
            this.memberName = "Unknown Member";
        }
    }

    public void setTrainerName(String trainerName) {
        if (trainerName != null && !trainerName.trim().isEmpty()) {
            this.trainerName = trainerName;
        } else {
            System.out.println("⚠️ Trainer name cannot be empty! Setting to 'Unknown Trainer'.");
            this.trainerName = "Unknown Trainer";
        }
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes > 0 && durationMinutes <= 240) { // максимум 4 часа
            this.durationMinutes = durationMinutes;
        } else {
            System.out.println("⚠️ Duration must be 1-240 minutes! Setting to 60.");
            this.durationMinutes = 60;
        }
    }

    public void setSessionType(String sessionType) {
        if (sessionType != null && !sessionType.trim().isEmpty()) {
            this.sessionType = sessionType;
        } else {
            System.out.println("⚠️ Session type cannot be empty! Setting to 'General Training'.");
            this.sessionType = "General Training";
        }
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed; // boolean не требует валидации
    }

    // 6. ADDITIONAL METHODS (оставляем без изменений)

    // Method 1: Extend session duration
    public void extendSession(int additionalMinutes) {
        if (additionalMinutes > 0) {
            durationMinutes += additionalMinutes;
            System.out.println("Session extended by " + additionalMinutes + " minutes. New duration: " + durationMinutes + " min");
        }
    }

    // Method 2: Mark session as completed
    public void markCompleted() {
        if (!isCompleted) {
            isCompleted = true;
            System.out.println("Session " + sessionId + " marked as completed.");
        } else {
            System.out.println("Session already completed.");
        }
    }

    // Method 3: Check if session is intensive (extra)
    public boolean isIntensive() {
        return durationMinutes > 90 || sessionType.equals("HIIT") || sessionType.equals("CrossFit");
    }

    // 7. toString() METHOD (оставляем без изменений)
    @Override
    public String toString() {
        return "WorkoutSession{" +
                "sessionId=" + sessionId +
                ", memberName='" + memberName + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", sessionType='" + sessionType + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}