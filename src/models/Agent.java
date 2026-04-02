package models;

import java.util.ArrayList;

import enums.Days;

public class Agent {

    private Branch branch;
    private Schedule schedule;

    public Agent(String rentalBranch, String location, String phoneNumber,
            float workingHours, ArrayList<Days> workingDays, boolean isAvailable) {

        this.branch = new Branch(rentalBranch, location, phoneNumber);
        this.schedule = new Schedule(workingHours, workingDays, isAvailable);
    }

    public Agent(Branch branch, Schedule schedule) {
        if (branch == null) {
            throw new IllegalArgumentException("Branch cannot be null");
        }

        if (schedule == null) {
            throw new IllegalArgumentException("Schedule cannot be null");
        }

        this.branch = branch;
        this.schedule = schedule;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "branch=" + branch +
                ", schedule=" + schedule +
                '}';
    }
}