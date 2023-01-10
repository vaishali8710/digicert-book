package org.digicert.service;

import java.util.List;
import java.util.Optional;

import org.digicert.core.BookRequest;
import org.digicert.core.BookResponse;
import org.digicert.data.BookRepository;
import org.digicert.exception.BookNotFoundException;
import org.digicert.models.Book;
import org.digicert.models.IssueStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
  @Autowired
  BookRepository bookRepository;

  /**
   * @return List of Books
   */
  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  /**
   * @param bookId book id
   * @return Book object
   */
  @Override
  public Book getBookById(Integer bookId) {
    Optional<Book> bookMaybe = bookRepository.findById(bookId);
    if(!bookMaybe.isPresent()) {
      throw new BookNotFoundException("Book", "book id", bookId);
    }
    return bookMaybe.get();
  }

  /**
   * @param bookName book nme
   * @return Book Object
   */
  @Override
  public Book getBookByName(String bookName) {
    Optional<Book> bookMaybe = bookRepository.findByName(bookName);
    if(!bookMaybe.isPresent()) {
      throw new BookNotFoundException("Book", "book name", bookName);
    }
    return bookMaybe.get();
  }

  /**
   * @param issueStatus issue Status
   * @return List of Books
   */
  @Override
  public List<Book> getBooksByIssueStatus(IssueStatus issueStatus) {
    return bookRepository.findByIssueStatus(issueStatus);
  }

  /**
   * @param bookRequest bookRequest
   * @return BookResponse Message
   */
  @Override
  public BookResponse create(BookRequest bookRequest) {
    Book book = new Book();
    book.setBookName(bookRequest.getBookName());
    book.setLanguage(book.getLanguage());
    book.setIssueStatus(bookRequest.getIssueStatus());
    bookRepository.save(book);
    return new BookResponse("New Book is added to the Library successfully");
  }

  /**
   * @param bookId book id
   */
  @Override
  public void delete(Integer bookId) {
    if (bookRepository.getById(bookId).getId().equals(bookId)){
      bookRepository.deleteById(bookId);
    }
  }

  /**
   * @param bookId bookId
   * @param bookRequest bookRequest
   * @return BookResponse message
   */
  @Override
  public BookResponse update(Integer bookId, BookRequest bookRequest) {
    Optional<Book> bookMaybe = bookRepository.findById(bookId);
    if (!bookMaybe.isPresent()) {
     // LOG.info("Book is not Present in the Library");
      return new BookResponse("Error updating Book details");
    }
    Book book = bookMaybe.get();
    book.setBookName(bookRequest.getBookName());
    book.setLanguage(bookRequest.getLanguage());
    book.setIssueStatus(bookRequest.getIssueStatus());
    bookRepository.save(book);
    return new BookResponse("Book is Updated in the Library successfully");
  }
}
