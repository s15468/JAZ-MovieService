package pl.pjatk.JulCho.GlobalHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler
{
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> HandleRunTimeException(RuntimeException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occurred on request. Exception Message: " + ex);
    }
}
