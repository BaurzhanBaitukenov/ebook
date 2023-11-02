package com.example.ebookspring.Repository;

import com.example.ebookspring.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
