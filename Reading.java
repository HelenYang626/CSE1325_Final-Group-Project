import java.time.LocalDate;

public class Reading extends Task {

    private int pages;

    // Constructor
    public Reading(String title, String description, LocalDate dueDate, boolean complete,
                   String category, int pages) {
        super(title, description, dueDate, complete, category);
        this.pages = pages;
    }

    // Getter
    public int getPages() {
        return this.pages;
    }

    // Setter
    public void setPages(int pages) {
        this.pages = pages;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() +
               "\nPages: " + this.pages;
    }
}