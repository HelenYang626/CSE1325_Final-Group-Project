import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ItemManagerFE 
{
    private static ItemManager manager = new ItemManager(); // object to store and manage all items

    private static JTextArea displayArea; // text area to display all items/messages

    // text fields for user input
    private static JTextField titleField;
    private static JTextField descField;
    private static JTextField dueDateField;

    // drop down boxes for item type and status
    private static JComboBox<String> typeBox;
    private static JComboBox<String> statusBox;

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Student Task & Assignment Management System"); // main menu
        frame.setSize(700, 600); // size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close when X
        frame.setLayout(null);

        // labels
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(20, 20, 100, 25);
        frame.add(titleLabel);

        JLabel descLabel = new JLabel("Description:");
        descLabel.setBounds(20, 55, 100, 25);
        frame.add(descLabel);

        JLabel dueLabel = new JLabel("Due Date (MM/DD/YYYY):");
        dueLabel.setBounds(20, 90, 150, 25);
        frame.add(dueLabel);

        JLabel typeLabel = new JLabel("Item Type:");
        typeLabel.setBounds(20, 125, 100, 25);
        frame.add(typeLabel);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(20, 160, 100, 25);
        frame.add(statusLabel);

        // text fields

        // user enters title
        titleField = new JTextField();
        titleField.setBounds(130, 20, 200, 25);
        frame.add(titleField);

        // user enters description
        descField = new JTextField();
        descField.setBounds(130, 55, 200, 25);
        frame.add(descField);

        // user enters due date in MM/DD/YYYY
        dueDateField = new JTextField(); // H FIXED: changed date format
        dueDateField.setBounds(180, 90, 150, 25);
        dueDateField.setText(LocalDate.now().plusDays(7).format(Item.DATE_FORMATTER)); // sets example date to be 7 days from current
        frame.add(dueDateField);

        // combo boxes

        // item category
        String[] itemTypes = {"Homework", "Quiz", "Project", "Exam", "Study", "Meeting", "Reading"};

        // drop down menu for item type
        typeBox = new JComboBox<>(itemTypes);
        typeBox.setBounds(130, 125, 200, 25);
        frame.add(typeBox);

        // choices for item progress status
        String[] statuses = {"Pending", "Finished"};

        // drop down menu for status
        statusBox = new JComboBox<>(statuses);
        statusBox.setBounds(130, 160, 200, 25);
        frame.add(statusBox);

        // buttons

        // adds new item
        JButton addButton = new JButton("Add Item");
        addButton.setBounds(370, 20, 130, 30);
        frame.add(addButton);

        // deletes item by title
        JButton deleteButton = new JButton("Delete Item");
        deleteButton.setBounds(520, 20, 130, 30);
        frame.add(deleteButton);

        // changes item status
        JButton updateButton = new JButton("Update Status");
        updateButton.setBounds(370, 60, 130, 30);
        frame.add(updateButton);

        // displays all items
        JButton displayButton = new JButton("Display All");
        displayButton.setBounds(520, 60, 130, 30);
        frame.add(displayButton);

        // show overdue items only
        JButton overdueButton = new JButton("Show Overdue");
        overdueButton.setBounds(370, 100, 130, 30);
        frame.add(overdueButton);

        // H ADDED: Searches for item
        JButton searchButton = new JButton("Search Item");
        searchButton.setBounds(520, 100, 130, 30);
        frame.add(searchButton);

        // output area

        // text area where results appear
        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // scroll bar to text area
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 220, 630, 300);
        frame.add(scrollPane);

        // button actions when clicked
        addButton.addActionListener(e -> addItem());
        deleteButton.addActionListener(e -> deleteItem());
        updateButton.addActionListener(e -> updateStatus());
        displayButton.addActionListener(e -> updateDisplay());
        overdueButton.addActionListener(e -> showOverdue());
        searchButton.addActionListener(e -> searchItem());

        frame.setVisible(true);
    }

    // add item
    private static void addItem()
    {
        try
        {
            String title = titleField.getText().trim();
            String desc = descField.getText().trim();

            // H ADDED: Date parsing w/ exception handling
            LocalDate due;
            try {
                due = LocalDate.parse(dueDateField.getText().trim(), Item.DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Use MM/DD/YYYY");
                return;
            }

            String type = (String) typeBox.getSelectedItem();
            String status = (String) statusBox.getSelectedItem();

            // H ADDED: Checks if title and date is empty
            if (title.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Title cannot be empty.");
                return;
            }
            if (due == null) {
                JOptionPane.showMessageDialog(null, "Due date cannot be empty.");
                return;
            }

            Item item = null;

            // homework
            if (type.equals("Homework"))
            {
                try { // prompt user for homework-specific attributes
                    double points = Double.parseDouble(JOptionPane.showInputDialog("Enter max points:"));
                    double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter weight:"));
                    int pages = Integer.parseInt(JOptionPane.showInputDialog("Enter page count:"));
                    int problems = Integer.parseInt(JOptionPane.showInputDialog("Enter number of problems:"));

                    // homework class validation handles invalid values
                    item = new Homework(title, desc, due, type, points, weight, pages, problems);
                    
                // H ADDED: catches invalid values
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number format.");
                    return;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                }
            } 

            // quiz
            else if (type.equals("Quiz"))
            {
                try { // prompt user for quiz-specific attributes
                    double points = Double.parseDouble(JOptionPane.showInputDialog("Enter max points:"));
                    double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter weight:"));
                    double time = Double.parseDouble(JOptionPane.showInputDialog("Enter time limit (minutes):"));
                    int questions = Integer.parseInt(JOptionPane.showInputDialog("Enter question count:"));

                    // quiz class validation handles invalid values
                    item = new Quiz(title, desc, due, type,points, weight, time, questions);
                    
                // H ADDED: catches invalid values
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number format.");
                    return;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                }
            }

            // project
            else if (type.equals("Project"))
            {
                try { // prompt user for project-specific attributes
                    double points = Double.parseDouble(JOptionPane.showInputDialog("Enter max points:"));
                    double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter weight:"));
                    int groupSize = Integer.parseInt(JOptionPane.showInputDialog("Enter group size:"));
                    boolean present = JOptionPane.showConfirmDialog(null, "Has presentation?", "Project", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

                    // project class validation handles invalid values
                    item = new Project(title, desc, due, type, points, weight, groupSize, present);
                    
                // H ADDED: catches invalid values
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number format.");
                    return;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                } 
            }

            // exam
            else if (type.equals("Exam"))
            {
                try { // prompt user for exam-specific attributes
                    double points = Double.parseDouble(JOptionPane.showInputDialog("Enter max points:"));
                    double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter weight:"));
                    double duration = Double.parseDouble(JOptionPane.showInputDialog("Enter duration (minutes):"));
                    String location = JOptionPane.showInputDialog("Enter location:");

                    // exam class validation handles invalid values
                    item = new Exam(title, desc, due, type, points, weight, duration, location);
                    
                // H ADDED: catches invalid values
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number format.");
                    return;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                }
            }

            // study
            else if (type.equals("Study"))
            {
                try { // prompt user for study-specific attributes
                    double hrs = Double.parseDouble(JOptionPane.showInputDialog("Enter estimated hours:"));
                    String location = JOptionPane.showInputDialog("Enter location:");

                    // study class validation handles invalid values
                    item = new Study(title, desc, due, type, hrs, location);
                    
                // H ADDED: catches invalid values
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number format.");
                    return;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                }            
            }

            // meeting
            else if (type.equals("Meeting"))
            {
                try { // prompt user for meeting-specific attributes
                    double hrs = Double.parseDouble(JOptionPane.showInputDialog("Enter estimated hours:"));
                    String location = JOptionPane.showInputDialog("Enter meeting location:");

                    // meeting class validation handles invalid values
                    item = new Meeting(title, desc, due, type, hrs, location);
                    
                // H ADDED: catches invalid values
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number format.");
                    return;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                }
            }

            // reading
            else if (type.equals("Reading"))
            {
                try { // prompt user for reading-specific attributes
                    double hrs = Double.parseDouble(JOptionPane.showInputDialog("Enter estimated hours:"));
                    int pages = Integer.parseInt(JOptionPane.showInputDialog("Enter pages to read:"));

                    // reading class validation handles invalid values
                    item = new Reading(title, desc, due, type, hrs, pages);

                // H ADDED: catches invalid values
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number format.");
                    return;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                }
            }

            // generic
            else
            {
                item = new Item(title, desc, due, type);
            }

            // status
            if (status.equals("Finished") && item != null)
            {
                item.setComplete(true);
            }

            if (item != null) {
                manager.addItem(item);
                clearInputs(); // calls method to auto clear input fields
                updateDisplay();
            }
        }
        // catches errors and shows specific messages for duplicates, validation, etc
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format. Please enter valid numbers.");
        }
        catch (DuplicateItemException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error adding item:\n" + e.getMessage());
        }
    }

    // delete item
    private static void deleteItem() 
    {
        try 
        {
            manager.removeItem(titleField.getText().trim());
            titleField.setText(""); 
            updateDisplay();

        } 
        catch (ItemNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error deleting item:\n" + e.getMessage());
        }
    }

    // update status
    private static void updateStatus() 
    {
        try 
        {
            String title = titleField.getText().trim();
            String status = (String) statusBox.getSelectedItem();

            Item item = manager.searchByTitle(title);

            if (item == null) 
            {
                JOptionPane.showMessageDialog(null, "Item not found.");
                return;
            }

            if (status.equals("Finished")) 
            {
                item.setComplete(true);
            } 
            else 
            {
                item.setComplete(false);
            }

            titleField.setText(""); 
            updateDisplay();

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Could not update status.");
        }
    }

    // display all items
    private static void updateDisplay() 
    {
        displayArea.setText("");

        Item[] items = manager.getAllItems();

        for (Item item : items) 
        {
            if (item != null) 
            {
                displayArea.append(item.toString() + "\n\n");
            }
        }
    }

    // show overdue
    private static void showOverdue() 
    {
        displayArea.setText("");

        Item[] items = manager.getOverdueItems();

        for (Item item : items) 
        {
            if (item != null) 
            {
                displayArea.append(item.toString() + "\n\n");
            }
        }
    }

    // H ADDED: Searches for item by title
    private static void searchItem()
    {
        String title = JOptionPane.showInputDialog(null, "Enter title to search:");
        if (title == null || title.trim().isEmpty()) return;
        
        Item item = manager.searchByTitle(title);
        
        if (item == null) {
            JOptionPane.showMessageDialog(null, "Item not found.");
        } else {
            JOptionPane.showMessageDialog(null, item.toString(), "Item Found", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // H ADDED: clearInputs() method - input fields auto cleared after item added
    private static void clearInputs() {
        titleField.setText("");
        descField.setText("");
        dueDateField.setText(LocalDate.now().plusDays(7).format(Item.DATE_FORMATTER));
    }
}