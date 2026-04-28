import java.time.LocalDate;

public class ItemManager {
    private Item[] items;
    public static final int MAX_ITEMS = 1000; // Max number of items

    // DEFAULT CONSTRUCTOR
    public ItemManager() {
        items = new Item[MAX_ITEMS];
    }

    // addItem method - adds an item to the first available slot
    public void addItem(Item item) throws DuplicateItemException {
        if (item == null) return; 

        // Check if array is full 
        if (items[items.length - 1] != null) {
            throw new IllegalArgumentException("Item list is full. Cannot add more items.");
        }

        // Check for duplicate title
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getTitle().equalsIgnoreCase(item.getTitle())) {
                throw new DuplicateItemException("Item '" + item.getTitle() + "' already exists.");
            }
        }

        // Add item to first null spot and add
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break; // Exit loop after adding item
            }
        }

        this.sortByDueDate(); // Auto-sort items by due date after adding
    }

    // removeItem method - removes an item by title
    public void removeItem(String title) throws ItemNotFoundException {
        if (title == null || title.trim().isEmpty()) {
            throw new ItemNotFoundException("Title cannot be empty.");
        }
        
        int removeIndex = -1; // Initialize remove index

        // Find index of item to remove
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getTitle().equalsIgnoreCase(title)) {
                removeIndex = i;
                break; // Exit loop after finding item
            }
        }

        if (removeIndex == -1) {
            throw new ItemNotFoundException("Item '" + title + "' not found.");
        }

        // Shift items left to fill gap
        for (int i = removeIndex; i < items.length - 1; i++) {
            items[i] = items[i + 1];
        }
        items[items.length - 1] = null; // Set last item to null after shifting
    }

    // sortItems method - sorts items by due date (earliest first)
    public void sortByDueDate() {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < items.length -1; i++) {
                if (items[i] == null || items[i + 1] == null) continue; // stop if we reach null items
                
                // Compare due dates and swap if necessary
                if (items[i].getDueDate().isAfter(items[i + 1].getDueDate())) {
                    Item temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                    swapped = true; // Set swapped to true to continue sorting
                }
            }
        }
    }

    // Search by title (case-insensitive)
    public Item searchByTitle(String title) {
        if (title == null) return null; // return null if title is null

        for (Item item : items) {
            if (item != null && item.getTitle().equalsIgnoreCase(title)) {
                return item; // return item if title matches
            }
        }
        return null; // returns null if no items match
    }

    // markComplete method - marks an item as complete
    public void markComplete(String title) throws ItemNotFoundException {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getTitle().equalsIgnoreCase(title)) {
                items[i].setComplete(true);
                return; // Exit method after marking complete
            }
        }
        throw new ItemNotFoundException("Item '" + title + "' not found.");
    }

    // getItems method - returns a new array of all non-null items
    public Item[] getAllItems() {
        int count = 0; // count non-null items first
        for (Item item : items) {
            if (item != null) {
                count++;
            } 
        }

        // Create new array of correct size and copy items
        Item[] result = new Item[count];
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                result[index++] = item;
            } 
        }
        return result;
    }

    // getOverdueItems method - returns an array of items that are overdue
    public Item[] getOverdueItems() {
        LocalDate today = LocalDate.now();
        int count = 0; // count overdue items first
        for (Item item : items) {
            if (item != null && item.getDueDate().isBefore(today) && !item.isComplete()) {
                count++;
            }
        }

        // Create new array of correct size and copy overdue items
        Item[] result = new Item[count];
        int index = 0;
        for (Item item : items) {
            if (item != null && item.getDueDate().isBefore(today) && !item.isComplete()) {
                result[index++] = item;
            }
        }
        return result;
    }

    // clearItems method - clears all items from manager
    public void clearItems() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
    }

    // getItemCount method - returns the number of non-null items
    public int getItemCount() {
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }

    // getIncompleteCount method - returns the number of incomplete items
    public int getIncompleteCount() {
        int count = 0; // count incomplete items first
        for (Item item : items) {
            if (item != null && !item.isComplete()) {
                count++;
            }
        }
        return count;
    }

    // toString method
    public String toString() {
        return "ItemManager: " + getItemCount() + " items, " + getIncompleteCount() + " incomplete.";
    }
}
