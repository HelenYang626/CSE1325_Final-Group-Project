import java.time.LocalDate;

public class Reading extends Task {

    private int pages;

    // Default constructor
    public Reading() {
        super();
        this.pages = 10;
        this.setType("Reading");
    }

    // Constructor
    public Reading(String title, String description, LocalDate dueDate,
                   String type, double estHrs, int pages) {
        super(title, description, dueDate, type, estHrs);
        this.pages = pages;
    }

    // Getter
    public int getPages() {
        return this.pages;
    }

    // Setter
    public void setPages(int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException("Pages cannot be negative.");
        }
        this.pages = pages;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() +
               "\nPages: " + this.pages;
    }
}
