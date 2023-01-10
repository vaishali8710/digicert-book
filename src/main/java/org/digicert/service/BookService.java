package org.digicert.service;

import java.util.List;

import org.digicert.core.BookRequest;
import org.digicert.core.BookResponse;
import org.digicert.models.Book;
import org.digicert.models.IssueStatus;
import org.springframework.stereotype.Component;

@Component
public interface BookService {
  //get all the books in the library
  List<Book> getAllBooks();

  //get Book by Id
  Book getBookById(Integer bookId);

  //get Book by Name
  Book getBookByName(String bookName);

  //get books in the library based on Issue Status
  List<Book>  getBooksByIssueStatus(IssueStatus issueStatus);

  // add a book in Library
  BookResponse create(BookRequest bookRequest);

  // Removes a Book from Library / Lost Status
  void delete(Integer bookId);

  // Update details of a Book
  BookResponse update(Integer bookId, BookRequest bookRequest);
}
