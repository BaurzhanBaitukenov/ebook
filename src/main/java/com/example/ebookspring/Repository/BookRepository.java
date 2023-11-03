package com.example.ebookspring.Repository;

import com.example.ebookspring.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT c from Book c WHERE c.bookName LIKE CONCAT('%', :query, '%')")
    List<Book> searchBooks(String query);
}
