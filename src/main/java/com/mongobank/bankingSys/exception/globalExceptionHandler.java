package com.mongobank.bankingSys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler({resourceNotFound.class})
    public ResponseEntity<apiResponse> resourceNotFoundExceptionHandler(resourceNotFound ex){
        String message=ex.getMessage();
        apiResponse aresponse=new apiResponse(message,false);
        return new ResponseEntity<apiResponse>(aresponse, HttpStatus.NOT_FOUND);
    }

}
