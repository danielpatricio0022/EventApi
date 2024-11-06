package org.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
  @RestController
  public class GlobalExceptionCustomized extends ResponseEntityExceptionHandler {
    /** Exceptions genéricas, herda de ResponseEntityExceptionHandler
     para sobrescrever e adicionar descriçoes detalhadas na exception */

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

}





