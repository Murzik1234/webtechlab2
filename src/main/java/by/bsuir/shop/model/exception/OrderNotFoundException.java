package by.bsuir.shop.model.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {

    }
    public OrderNotFoundException(String message) {
        super(message);
    }
}
