package org.digicert.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

  public BookNotFoundException(String bookName, String fieldName, Object fieldValue) {
    super(String.format("%s not found with %s : '%s'", bookName, fieldName, fieldValue));
  }
}
