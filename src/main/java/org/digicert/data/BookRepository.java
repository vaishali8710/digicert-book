package org.digicert.data;

import java.util.List;
import java.util.Optional;

import org.digicert.models.Book;
import org.digicert.models.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
  Optional<Book> findByName(String bookName);

  List<Book> findByIssueStatus(IssueStatus issueStatus);
}
