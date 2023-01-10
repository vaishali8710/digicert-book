package org.digicert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookLibraryApplication {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    SpringApplication.run(BookLibraryApplication.class, args);
  }
}