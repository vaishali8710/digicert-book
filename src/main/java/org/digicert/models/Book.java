package org.digicert.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String bookName;
  private String language;
  @Enumerated(EnumType.STRING)
  private IssueStatus issueStatus;

  public Book() {
  }

  public Book(Integer id, String bookName, String language, IssueStatus issueStatus) {
    this.id = id;
    this.bookName = bookName;
    this.language = language;
    this.issueStatus = issueStatus;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public IssueStatus getIssueStatus() {
    return issueStatus;
  }

  public void setIssueStatus(IssueStatus issueStatus) {
    this.issueStatus = issueStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Objects.equals(id, book.id) && Objects.equals(bookName, book.bookName) && Objects.equals(language, book.language) && issueStatus == book.issueStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bookName, language, issueStatus);
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", bookName='" + bookName + '\'' +
        ", language='" + language + '\'' +
        ", issueStatus=" + issueStatus +
        '}';
  }
}
