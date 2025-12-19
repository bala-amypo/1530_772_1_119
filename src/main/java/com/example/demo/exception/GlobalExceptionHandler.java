import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
public package com.example.demo.exception;

ResponseEntity<String>handleNotFound(ResourceNotFoundException ex) {
return new ResponseEntity<>(ex.getMessage(),HttpStatus.Not_Found);
}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>>handlevalidationerror(MethodArgumentNotValidException ex){
    Map<String,String>error-new HasMap<>();
    ex.getBindingResult().getFieldErrors().foreach(error->errors.put(error.getDefaultMessage())
    return new ReponseEntity<>(errors,HttpStatus.Bad_Request);
}
}