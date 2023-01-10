package org.digicert.core;

public class BookResponse {
  private String message;

  public BookResponse(String message){
    this.message = message;
  }

  public void setMessage(String message){
    this.message = message;
  }

  public String getMessage(){
    return message;
  }
}
