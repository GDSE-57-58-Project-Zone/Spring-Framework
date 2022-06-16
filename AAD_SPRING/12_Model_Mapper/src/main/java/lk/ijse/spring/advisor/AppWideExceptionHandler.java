package lk.ijse.spring.advisor;

import lk.ijse.spring.util.ResponseUtil;
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
    public ResponseUtil exceptionHandler(Exception e) {
       return new ResponseUtil(500, e.getMessage(), null);
    }
}
