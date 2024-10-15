package pl.pingwit.dentalmanager.exceptionhandling;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
