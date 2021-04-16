package mini.exceptions;

public class MiniEcommerceException extends Throwable{
    public MiniEcommerceException() {
    }

    public MiniEcommerceException(String message) {
        super(message);
    }

    public MiniEcommerceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MiniEcommerceException(Throwable cause) {
        super(cause);
    }
}
