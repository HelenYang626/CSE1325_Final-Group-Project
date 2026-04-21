import java.time.LocalDate;

public class Meeting extends Task {

    private double duration;
    private String location;

    // Constructor
    public Meeting(String title, String description, LocalDate dueDate, boolean complete,
                   String category, double duration, String location) {
        super(title, description, dueDate, complete, category);
        this.duration = duration;
        this.location = location;
    }

    // Getters
    public double getDuration() {
        return this.duration;
    }

    public String getLocation() {
        return this.location;
    }

    // Setters
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() +
               "\nDuration: " + this.duration +
               "\nLocation: " + this.location;
    }
}