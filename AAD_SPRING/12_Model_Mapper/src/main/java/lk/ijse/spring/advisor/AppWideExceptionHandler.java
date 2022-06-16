package lk.ijse.spring.advisor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler({Exception.class})
    public String exceptionHandler(Exception e) {
        return e.getMessage();
    }
}
