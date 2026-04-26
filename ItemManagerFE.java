import javax.swing.*;
import java.time.LocalDate;

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

        JLabel dueLabel = new JLabel("Due Date:");
        dueLabel.setBounds(20, 90, 100, 25);
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

        // user enters due date in yyyy-mm-dd
        dueDateField = new JTextField("2026-04-28");
        dueDateField.setBounds(130, 90, 200, 25);
        frame.add(dueDateField);

        // combo boxes

        // item category
        String[] itemTypes = {"Homework", "Quiz", "Project", "Exam", "Study", "Meeting", "Reading"};

        // drop down menu for item type
        typeBox = new JComboBox<>(itemTypes);
        typeBox.setBounds(130, 125, 200, 25);
        frame.add(typeBox);

        // choices for item progress status
        String[] statuses = {"Pending", "In Progress", "Finished"};

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
        overdueButton.setBounds(370, 100, 280, 30);
        frame.add(overdueButton);

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

        frame.setVisible(true);
    }

    // add item
    private static void addItem() 
    {
        try 
        {
            // read input value
            String title = titleField.getText().trim();
            String desc = descField.getText().trim();

            // convert text into LocalDate
            LocalDate due = LocalDate.parse(dueDateField.getText().trim());

            // get selected type and status
            String type = (String) typeBox.getSelectedItem();
            String status = (String) statusBox.getSelectedItem();

            // create new item object
            Item item = new Item(title, desc, due, false, type);

            // if finished, mark as complete
            if (status.equals("Finished")) 
            {
                item.setComplete(true);
            }

            manager.addItem(item); // add item to mananger

            updateDisplay();

        } 
        catch (Exception e) 
        {
            displayArea.setText("Error adding item.\nCheck inputs.");
        }
    }

    // delete item
    private static void deleteItem() 
    {
        try 
        {
            manager.removeItem(titleField.getText().trim());
            updateDisplay();

        } 
        catch (Exception e) 
        {
            displayArea.setText("Item not found.");
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
                displayArea.setText("Item not found.");
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

            updateDisplay();

        } 
        catch (Exception e) 
        {
            displayArea.setText("Could not update status.");
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
}
