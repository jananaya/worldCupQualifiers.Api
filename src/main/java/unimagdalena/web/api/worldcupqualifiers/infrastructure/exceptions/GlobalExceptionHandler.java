package unimagdalena.web.api.worldcupqualifiers.infrastructure.exceptions;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request) {
        List<String> errorMessages = exception.getAllErrors().stream()
            .map(error -> error.getDefaultMessage())
            .distinct()
            .toList();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, request.getDescription(false), errorMessages);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
