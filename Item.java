import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Item {
    // INSTANCE VARIABLES
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean complete;
    private String type; // Stores the type of item such as "Exam", "Homework", "Project", etc.

    // CONSTANTS
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // For consistent date formatting
    private static final int MAX_DESC_LENGTH = 50; 

    // DEFAULT CONSTRUCTOR
    public Item() {
        this.setTitle("Untitled");
        this.setDescription( "");
        this.dueDate = LocalDate.now().plusDays(7); // Default due date is 7 days
        this.complete = false; // Always starts as an incomplete item
        this.setType("Generic"); // Default type
    }

    // PARAMETERIZED CONSTRUCTOR
    public Item(String title, String description, LocalDate dueDate, String type) {
        this.setTitle(title);
        this.setDescription(description);
        this.setDueDate(dueDate);
        this.complete = false; // Always starts as an incomplete item
        this.setType(type); 
    }

    // ACCESSORS
    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public String getType() {
        return this.type;
    }

    // MUTATORS
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) { // checks for null or empty title
            throw new IllegalArgumentException("Title cannot be empty.");
        } else {
            this.title = title;
        }
    }

    public void setDescription(String description) {
        this.description = (description == null) ? "" : description; // Set to empty string if null
    }

    public void setDueDate(LocalDate dueDate) {
        if (dueDate == null) { 
            throw new IllegalArgumentException("Due date cannot be null.");
        } else {
            this.dueDate = dueDate;
        }
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    // setType() method - sets the type of item
    public void setType(String type) {
        this.type = (type == null) ? "Generic" : type; // Default to "Generic" if null
    }

    // isOverdue() method - checks if the item is overdue
    public boolean isOverdue() {
        return !complete && dueDate.isBefore(LocalDate.now());
    }

    // getStatusSymbol() method - returns a symbol representing the status of the item
    public String getStatusSymbol() {
        if (complete) {
            return "✓"; // completed
        } else if (isOverdue()) {
            return "!"; // overdue
        } else {
            return "o"; // pending
        }
    }

    // toString() method
    public String toString() {
        String status = complete ? "[✓ COMPLETE]" : (isOverdue() ? "[! OVERDUE]" : "[○ PENDING]");
        String displayDesc = description.length() > MAX_DESC_LENGTH ? description.substring(0, MAX_DESC_LENGTH - 3) + "..." : description;
        return status + " " + title + " | Type: " + type + " | Due: " + dueDate.format(DATE_FORMATTER) + " | Description: " + displayDesc;
    }
}
