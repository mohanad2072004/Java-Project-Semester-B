import java.util.ArrayList;

public class Agent {
    private Branch branch;
    private Schedule schedule;

    public Agent(String rentalBranch, float workingHours, ArrayList<Days> workingdays, boolean isAvailable){
        branch = new Branch(rentalBranch);
        schedule = new Schedule(workingHours,workingdays,isAvailable);
    }

    public Agent(Branch branch, Schedule schedule) {
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
                "branch:" + branch +
                ", schedule:" + schedule +
                '}';
    }
}
