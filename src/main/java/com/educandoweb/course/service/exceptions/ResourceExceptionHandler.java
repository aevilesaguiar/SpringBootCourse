package com.educandoweb.course.service.exceptions;

import com.educandoweb.course.resources.exceptions.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //essa anotação que vai interceptar as exceções que acontecerem para que esse objeto possa executar um possivel tratamento
public class ResourceExceptionHandler  {

    @ExceptionHandler(ResourceNotFoundException.class) //com essa anotação eu estou dizendo que o método resourceNotFound vai interceptar qualquer exceção do tipo ResourceNotFoundException e vai fazer o tratamento
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
            String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err= new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

}
