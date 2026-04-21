public class ItemNotFoundException extends Exception {
    
    public ItemNotFoundException() {
        super("The specified item was not found.");
    }
    
    public ItemNotFoundException(String message) {
        super(message);
    }
}
