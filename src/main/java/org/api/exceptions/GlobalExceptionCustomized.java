package org.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

    List<String> errors = ex.getBindingResult()
            .getAllErrors()
            .stream()
            .map(error -> ((FieldError) error).getDefaultMessage())
            .collect(Collectors.toList());

    ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            "Validation failed",
            String.join(", ", errors)
    );

    // Retornando HTTP 400 (BAD REQUEST) com a lista de erros
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
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





