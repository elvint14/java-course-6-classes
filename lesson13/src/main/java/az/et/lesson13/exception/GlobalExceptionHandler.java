package az.et.lesson13.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.UUID;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public CommonErrorResponse handleConstraintViolationException(ConstraintViolationException ex) {
        addErrorLog(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "ConstraintViolationException");
        return new CommonErrorResponse(UUID.randomUUID().toString(), HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public CommonErrorResponse handleConstraintViolationException(StudentNotFoundException ex) {
        addErrorLog(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "StudentNotFoundException");
        return new CommonErrorResponse(UUID.randomUUID().toString(), HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        addErrorLog(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "MethodArgumentNotValidException");
        return ResponseEntity.badRequest()
                .body(new CommonErrorResponse(UUID.randomUUID().toString(), HttpStatus.BAD_REQUEST, ex.getMessage()));

    }

    protected void addErrorLog(Integer errorCode, String errorMessage, String ex) {
        log.error("[Error] | Code: {} | Type: {} | Path: {} | Elapsed time: {} ms | Message: {}",
                errorCode, ex, "THERE WILL BE URI", "elapsed_time:" + System.currentTimeMillis(), errorMessage);
    }

    @Data
    @AllArgsConstructor
    static class CommonErrorResponse {

        private final String id;
        private final Integer code;
        private final String message;

        public CommonErrorResponse(String id, HttpStatus status, String message) {
            this.id = id;
            this.code = status.value();
            this.message = message;
        }

    }

}
