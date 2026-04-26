import java.time.LocalDate;

public class Task extends Item {

    private String category;

    // Default constructor
    public Task() {
        super();
        this.category = "General";
    }

    // Constructor
    public Task(String title, String description, LocalDate dueDate, boolean complete, String category) {
        super(title, description, dueDate, complete, "Task");
        this.category = category;
    }

    // Getter
    public String getCategory() {
        return this.category;
    }

    // Setter
    public void setCategory(String category) {
        this.category = category;
    }

    // getType method
    @Override
    public String getType() {
        return "Task";
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + 
               "\nCategory: " + this.category;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        // return this.category.equals(task.category); changed to compare titles instead of categories
        return getTitle().equals(task.getTitle());
    }
}
