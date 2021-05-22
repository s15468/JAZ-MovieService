package pl.pjatk.JulCho.Exception.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController
{
    @GetMapping("")
    public ResponseEntity<String> GetExceptionMessage()
    {
        throw new RuntimeException();
    }
}
