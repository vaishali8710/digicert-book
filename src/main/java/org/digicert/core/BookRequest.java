package org.digicert.core;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.digicert.models.IssueStatus;

public class BookRequest {
  @NotBlank
  @NotNull
  private String id;
  @NotBlank
  @NotNull
  private String bookName;
  @NotBlank
  @NotNull
  private String language;
  @NotBlank
  @NotNull
  @Enumerated(EnumType.STRING)
  private IssueStatus issueStatus;

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
}
