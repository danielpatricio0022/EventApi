package org.api.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
@ControllerAdvice
  @RestController
  public class GlobalExceptionCustomized  {

    @ExceptionHandler(ConflictException.class)
    public final ResponseEntity<ExceptionResponse> handleConflictException(ConflictException ex, WebRequest request) {

      ExceptionResponse exceptionResponse = new ExceptionResponse(
              new Date(), // timeStamp
              ex.getMessage(), // message
              request.getDescription(false) // detalhes da requisição
      );

      // HTTP 409 (CONFLICT)
      return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(UnprocessableException.class)
    public final ResponseEntity<ExceptionResponse> handleUnprocessableException(UnprocessableException ex, WebRequest request) {

      ExceptionResponse exceptionResponse = new ExceptionResponse(
              new Date(), // timeStamp
              ex.getMessage(), // message
              request.getDescription(false) // detalhes da requisição
      );

      // HTTP 422 (UNPROCESSABLE ENTITY)
      return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {

      ExceptionResponse exceptionResponse = new ExceptionResponse(
              new Date(), // timeStamp
              ex.getMessage(), // message
              request.getDescription(false) // detalhes da requisição
      );

      // HTTP 404 (NOT FOUND)
      return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}





