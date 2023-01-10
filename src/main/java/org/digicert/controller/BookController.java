package org.digicert.controller;

import java.util.List;

import org.digicert.core.BookRequest;
import org.digicert.core.BookResponse;
import org.digicert.models.Book;
import org.digicert.models.IssueStatus;
import org.digicert.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

  @Autowired
  BookService bookService;

  /**
   * Get List of All the books in Library
   * @return List of Book
   */
  @GetMapping("/all")
  public ResponseEntity<List<Book>> getAllBooks () {
    List<Book> books = bookService.getAllBooks();
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  /**
   * Find book in library using book id
   * @param bookId book id
   * @return Book object
   */
  @GetMapping("/search/{bookId}")
  public ResponseEntity<Book> getBookById (@PathVariable("bookId") Integer bookId) {
    Book book = bookService.getBookById(bookId);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  /**
   * Find book in library using book name
   * @param bookName book name
   * @return Book object
   */
  @GetMapping("/search/{bookName}")
  public ResponseEntity<Book> getBookByName (@PathVariable("bookName") String bookName) {
    Book book = bookService.getBookByName(bookName);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  /**
   * Get List of All the books in Library with specific Issue Status
   * @param issueStatus issue status
   * @return List of Book
   */
  @GetMapping("/search/{bookStatus}")
  public ResponseEntity<List<Book>> getBooksByIssueStatus (@PathVariable("bookStatus") IssueStatus issueStatus) {
    List<Book> books = bookService.getBooksByIssueStatus(issueStatus);
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  /**
   * Adds a Book to the Library
   * @param bookRequest bookRequest
   * @return BookResponse message
   */
  @PostMapping("/add")
  public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest) {
    BookResponse bookCreated = bookService.create(bookRequest);
    return new ResponseEntity<>(bookCreated, HttpStatus.CREATED);
  }

  /**
   * Updates a Book information in the Library with provided BookRequest
   * @param id book id
   * @param bookRequest bookRequest
   * @return BookResponse message
   */
  @PutMapping("/update/{id}")
  public ResponseEntity<BookResponse> updateBook(@PathVariable Integer id, @RequestBody BookRequest bookRequest) {
    BookResponse bookResponse = bookService.update(id, bookRequest);
    return new ResponseEntity<>(bookResponse, HttpStatus.OK);
  }

  /**
   * Deletes a Book information in the Library by Id
   * @param id book id
   * @return void
   */
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteBook(@PathVariable("id") Integer id) {
    bookService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
