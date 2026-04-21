public class DuplicateItemException extends Exception {
    
    public DuplicateItemException() {
        super("An item with this title already exists.");
    }
    
    public DuplicateItemException(String message) {
        super(message);
    }
}