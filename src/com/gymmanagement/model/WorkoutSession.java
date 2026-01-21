package com.gymmanagement.model;

import com.gymmanagement.exception.GymException;

public class WorkoutSession {
    private int sessionId;
    private String memberName;
    private String trainerName;
    private int duration;
    private String type;
    private boolean isCompleted;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int duration, String type, boolean isCompleted) throws GymException {
        if (sessionId <= 0) throw new GymException("Session ID must be positive!");
        if (duration < 20) throw new GymException("Session duration too short!");

        this.sessionId = sessionId;
        this.memberName = memberName;
        this.trainerName = trainerName;
        this.duration = duration;
        this.type = type;
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "📅 Session [" + sessionId + "] Member: " + memberName +
                " | Trainer: " + trainerName + " | " + duration + " min";
    }
}