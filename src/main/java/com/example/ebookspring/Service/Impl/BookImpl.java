package com.example.ebookspring.Service.Impl;

import com.example.ebookspring.Dto.BookDto;
import com.example.ebookspring.Models.Book;
import com.example.ebookspring.Repository.BookRepository;
import com.example.ebookspring.Service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookImpl implements BookService {

    private final BookRepository bookRepository;


    // Get all books
    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return books.stream().map(this::mapToBookDto).collect(Collectors.toList());
    }


    // create Book
    @Override
    public Book createBook(BookDto bookDto){
        return bookRepository.save(mapToBook(bookDto));
    }


// Find book By id
    @Override
    public BookDto getBookById(long bookId) {
        Book book = bookRepository.findById(bookId).get();
        return mapToBookDto(book);
    }


    // Delete book By Id
    @Override
    public void deleteBook(long bookId) {
        bookRepository.deleteById(bookId);
    }


    // Get BookEntity by Id
    @Override
    public Book getBookEntityById(long bookId) {
        return bookRepository.findById(bookId).get();
    }


    // Edit Book Entity
    @Override
    public void editBookEntity(Book book) {
        bookRepository.save(book);
    }


    //    Mapper
    private Book mapToBook(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.getId())  // Set the id from the dto
                .bookName(bookDto.getBookName())
                .author(bookDto.getAuthor())
                .description(bookDto.getDescription())
                .photoURL(bookDto.getPhotoURL())
                .price(bookDto.getPrice())
                .demoVersion(bookDto.getDemoVersion())
                .build();
    }

    private BookDto mapToBookDto(Book book) {

        return BookDto.builder()
                .id(book.getId())
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .description(book.getDescription())
                .photoURL(book.getPhotoURL())
                .price(book.getPrice())
                .demoVersion(book.getDemoVersion())
                .build();
    }
}
