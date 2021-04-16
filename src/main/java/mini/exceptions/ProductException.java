package mini.exceptions;

public class ProductException extends MiniEcommerceException{
    public ProductException() {
    }

    public ProductException(String message) {
        super(message);
    }
}
