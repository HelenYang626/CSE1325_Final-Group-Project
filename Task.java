import java.time.LocalDate;

public class Task extends Item {

    private double estHrs; // changed 'category' instance variable which was not used to 'estHrs' 

    // Default constructor
    public Task() {
        super();
        this.estHrs = 1.0;
        this.setType("Task"); // sets type as 'Task'
    }

    // Constructor
    public Task(String title, String description, LocalDate dueDate, String type, double estHrs) {
        super(title, description, dueDate, type); // updated constructor 
        this.setEstHrs(estHrs); // changed instance variable to 'estHrs'
    }

    // Getter
    public double getEstHrs() { // changed it to get estHrs
        return this.estHrs;
    }

    // Setter
    public void setEstHrs(double estHrs) { // changed it to get estHrs
        if (estHrs < 0) {
            throw new IllegalArgumentException("Estimated time cannot be negative.");
        }
        this.estHrs = estHrs;
    }

    // COMMENTED OUT - not needed as the method is already in Item.java file
    /* getType method
    @Override
    public String getType() {
        return "Task";
    }
    */

    // toString method
    @Override
    public String toString() {
        return super.toString() + 
               "\nEstimated Hours: " + this.estHrs + " hrs";
    }

    // COMMENTED OUT - not used anywhere in GUI for this project
    /* equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        // return this.category.equals(task.category); changed to compare titles instead of categories
        return getTitle().equals(task.getTitle());
    }
    */
}
