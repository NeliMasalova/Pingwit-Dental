package pl.pingwit.dentalmanager.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandler {

    // удали org.springframework.web.bind.annotation. и добавь импорт
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.toString());
    }

    // удали org.springframework.web.bind.annotation. и добавь импорт
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(e.toString());
    }
}
