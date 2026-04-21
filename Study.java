import java.time.LocalDate;

public class Study extends Task {

    private double estimatedHrs;
    private String location;

    // Constructor
    public Study(String title, String description, LocalDate dueDate, boolean complete,
                 String category, double estimatedHrs, String location) {
        super(title, description, dueDate, complete, category);
        this.estimatedHrs = estimatedHrs;
        this.location = location;
    }

    // Getters
    public double getEstimatedHrs() {
        return this.estimatedHrs;
    }

    public String getLocation() {
        return this.location;
    }

    // Setters
    public void setEstimatedHrs(double estimatedHrs) {
        this.estimatedHrs = estimatedHrs;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() +
               "\nEstimated Hours: " + this.estimatedHrs +
               "\nLocation: " + this.location;
    }
}