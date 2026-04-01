package models;

import java.util.ArrayList;

import enums.Days;

public class Schedule {
    private float workingHours;
    private ArrayList<Days> workingDays;
    private boolean isAvailable;

    public Schedule(float workingHours, ArrayList<Days> workingDays, boolean isAvailable) {
        if (workingHours < 0 || workingHours > 24) {
            throw new IllegalArgumentException("Invalid working hours");
        }
        this.workingHours = workingHours;
        this.workingDays = workingDays != null ? workingDays : new ArrayList<>();
        this.isAvailable = isAvailable;
    }

    public float getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(float workingHours) {
        this.workingHours = workingHours;
    }

    public ArrayList<Days> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(ArrayList<Days> workingDays) {
        this.workingDays = workingDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        isAvailable = available;
    }

    public void addDay(Days d) {
        workingDays.add(d);
    }

    public void removeDay(Days d) {
        workingDays.remove(d);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "workingHours=" + workingHours +
                ", workingDays=" + workingDays +
                ", is Available?:" + isAvailable +
                '}';
    }
}
