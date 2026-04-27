import java.time.LocalDate;

public class Meeting extends Task {
    private String location;

    // Added default constructor
    public Meeting() {
        super();
        this.location = "TBD";
        this.setType("Meeting");
    }

    // Constructor
    public Meeting(String title, String description, LocalDate dueDate,
                   String type, double estHrs, String location) {
        super(title, description, dueDate, type, estHrs);
        this.location = location;
    }

    // Getters
    /* COMMENTED OUT: method already in Task class
    public double getDuration() {
        return this.duration;
    }
    */ 

    public String getLocation() {
        return this.location;
    }

    // Setters
    /* COMMENTED OUT: method already in Task class
    public void setDuration(double duration) {
        this.duration = duration;
    }
    */

    public void setLocation(String location) {
        this.location = location;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() +
               "\nLocation: " + this.location;
    }
}
