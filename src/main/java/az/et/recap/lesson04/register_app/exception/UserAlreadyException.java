package az.et.recap.lesson04.register_app.exception;

public class UserAlreadyException extends RuntimeException {

    public UserAlreadyException(String message) {
        super(message);
    }

}
