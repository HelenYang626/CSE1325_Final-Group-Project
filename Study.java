import java.time.LocalDate;

public class Study extends Task {
    private String location;

    // Added default constructor
    public Study() {
        super();
        this.location = "TBD";
        this.setType("Study");
    }
    
    // Constructor
    public Study(String title, String description, LocalDate dueDate, String type, double estHrs, String location) {
        super(title, description, dueDate, type, estHrs);
        this.setLocation(location);
    }

    // Getters
    // COMMENTED OUT: getEstHrs() method already in 'Task' class
    /* 
    public double getEstimatedHrs() {
        return this.estimatedHrs;
    }
    */

    public String getLocation() {
        return this.location;
    }

    // Setters
    // COMMENTED OUT: setEstHrs() method already in 'Task' class
    /*
    public void setEstimatedHrs(double estimatedHrs) {
        this.estimatedHrs = estimatedHrs;
    }
    */

    public void setLocation(String location) {
        this.location = (location == null) ? "TBD" : location; // added validation when setting location
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() +
               "\nLocation: " + this.location;
    }
}
