package com.example.ebookspring.Service;

import com.example.ebookspring.Dto.BookDto;
import com.example.ebookspring.Models.Book;

import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();
    Book createBook(BookDto bookDto);
    BookDto getBookById(long bookId);
    void deleteBook(long bookId);
    Book getBookEntityById(long bookId);
    void editBookEntity(Book book);
    List<BookDto> searchBooks(String query);
}
