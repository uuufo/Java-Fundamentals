package labs_examples.datastructures.additional_examples.exceptions;

public class EmptyQueueException extends Exception {
    @Override
    public String toString() {
        return "EmptyQueueException - There is nothing to remove();";
    }
}
