package mini.exceptions;

public class RegisterUserException extends MiniEcommerceException{
    public RegisterUserException() {
    }

    public RegisterUserException(String message) {
        super(message);
    }
}
