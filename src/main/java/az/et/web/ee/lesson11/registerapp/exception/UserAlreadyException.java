package az.et.web.ee.lesson11.registerapp.exception;

public class UserAlreadyException extends RuntimeException {

    public UserAlreadyException(String message) {
        super(message);
    }

}
