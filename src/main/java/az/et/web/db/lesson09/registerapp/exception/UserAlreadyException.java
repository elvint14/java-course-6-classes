package az.et.web.db.lesson09.registerapp.exception;

public class UserAlreadyException extends RuntimeException {

    public UserAlreadyException(String message) {
        super(message);
    }

}
