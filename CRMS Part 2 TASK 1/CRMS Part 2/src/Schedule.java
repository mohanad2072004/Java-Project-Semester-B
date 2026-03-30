import java.util.ArrayList;

public class Schedule {
    private float workingHours;
    private ArrayList<Days> workingdays;
    private boolean isAvailable;

    public Schedule(float workingHours, ArrayList<Days> workingdays, boolean isAvailable) {
        if(workingHours <0){throw new IllegalArgumentException("Invalid working hours");}
        this.workingHours = workingHours;
        this.workingdays = workingdays;
        this.isAvailable = isAvailable;
    }

    public float getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(float workingHours) {
        this.workingHours = workingHours;
    }

    public ArrayList<Days> getWorkingdays() {
        return workingdays;
    }

    public void setWorkingdays(ArrayList<Days> workingdays) {
        this.workingdays = workingdays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        isAvailable = available;
    }

    public void addDay(Days d){
        workingdays.add(d);
    }
    public void removeDay(Days d){
        for(Days day: workingdays){
            if(d.equals(day)){
                workingdays.remove(d);
            }
        }
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "workingHours=" + workingHours +
                ", workingdays=" + workingdays +
                ", is Available?:" + isAvailable +
                '}';
    }
}
