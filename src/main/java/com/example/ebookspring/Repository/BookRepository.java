package com.example.ebookspring.Repository;

import com.example.ebookspring.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT c FROM Book c WHERE LOWER(c.bookName) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Book> searchBooks(String query);
}
