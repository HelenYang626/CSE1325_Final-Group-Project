import java.time.LocalDate;
import java.util.Scanner;

public class ItemManagerFE 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        ItemManager manager = new ItemManager();

        boolean running = true;

        while (running) 
        {
            System.out.println("\n----- STUDENT TASK MANAGER -----");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Mark Item Complete");
            System.out.println("4. View All Items");
            System.out.println("5. View Overdue Items");
            System.out.println("6. Search Item by Title");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //comsume newline

            try // handle user choices and potential exceptions
            {
                switch (choice) // switch statement to handle user menu choices
                {
                    case 1: // add Item
                    {
                        addItem(scanner, manager); // call method to add item
                        break;
                    }
                    case 2: // remove Item
                    {
                        System.out.print("Enter title to remove: ");
                        String removeTitle = scanner.nextLine();
                        manager.removeItem(removeTitle);
                        System.out.println("Item removed.");
                        break;
                    }
                    case 3: // mark Item complete
                    {
                        System.out.print("Enter title to mark complete: ");
                        String completeTitle = scanner.nextLine();
                        manager.markComplete(completeTitle);
                        System.out.println("Item marked as complete.");
                        break;
                    }
                    case 4: // view all Items
                    {
                        printItems(manager.getAllItems());
                        break;
                    }
                    case 5: // view overdue Items
                    {
                        printItems(manager.getOverdueItems());
                        break;
                    }
                    case 6: // search Item by title
                    {
                        System.out.print("Enter title to search: ");
                        String searchTitle = scanner.nextLine();
                        Item found = manager.searchByTitle(searchTitle);

                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Item not found.");
                        }
                        break;
                    }
                    case 7: // exit
                    {
                        running = false;
                        System.out.println("Exiting program...");
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid option.");
                    }
                }

            } 
            catch (DuplicateItemException | ItemNotFoundException e) // handle custom exceptions for duplicate items and item not found
            {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // add Item method to handle user input for adding different types of items and set common fields
    private static void addItem(Scanner scanner, ItemManager manager) throws DuplicateItemException 
    {
        // display item type options to user
        System.out.println("\nAdd Item Type:");
        System.out.println("1. Homework");
        System.out.println("2. Quiz");
        System.out.println("3. Exam");
        System.out.println("4. Project");
        System.out.println("5. Study");
        System.out.println("6. Meeting");
        System.out.println("7. Reading");

        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Due Date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());

        Item item = null;

        switch (typeChoice) 
        {
            case 1: // homework
            {
                item = new Homework();
                break;
            }
            case 2: // quiz
            {
                item = new Quiz();
                break;
            }
            case 3: // exam
            {
                item = new Exam();
                break;
            }
            case 4: // project
            {
                item = new Project();
                break;
            }
            case 5: // study
            {
                item = new Study(title, description, dueDate, false, "Study", 2.0, "Library");
                break;
            }
            case 6: // meeting
            {
                item = new Meeting(title, description, dueDate, false, "Meeting", 1.0, "Room");
                break;
            }
            case 7: // reading
            {
                item = new Reading(title, description, dueDate, false, "Reading", 10);
                break;
            }
            default:
            {
                System.out.println("Invalid type.");
                return;
            }
        }

        // set shared fields if using default constructors
        if (item != null) 
        {
            item.setTitle(title);
            item.setDescription(description);
            item.setDueDate(dueDate);
        }

        manager.addItem(item); // add item to manager and handle potential duplicate item exception
        System.out.println("Item added successfully!");
    }

    // method to print items in a readable format and handle case where no items are found
    private static void printItems(Item[] items) 
    {
        if (items.length == 0) // handle case where no items are found
        {
            System.out.println("No items found.");
            return;
        }

        System.out.println("\n----- ITEMS -----");
        for (Item item : items) // loop through items and print each one
        {
            System.out.println(item);
            System.out.println("----------------------");
        }
    }
}
