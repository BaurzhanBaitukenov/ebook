package com.example.ebookspring.Contreoller;

import com.example.ebookspring.Dto.BookDto;
import com.example.ebookspring.Models.Book;
import com.example.ebookspring.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

//  Get all book
    @GetMapping()
    public String getBooks(Model model) {
        List<BookDto> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "book/books-list";
    }

    // get Book by Id
    @GetMapping("/{bookId}")
    public String getBookById(@PathVariable("bookId") long bookId, Model model) {
        BookDto bookDto = bookService.getBookById(bookId);
        model.addAttribute("book", bookDto);
        return "book/book-detail";
    }


    // Delete Book by Id
    @GetMapping("/{bookId}/delete")
    public String deleteBookById(@PathVariable("bookId") long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books";
    }


//    create book
    @GetMapping("/create")
    public String getCreateBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/book-create";
    }

    @PostMapping("/create")
    public String postCreateBook(@ModelAttribute("book") BookDto bookDto) {
        bookService.createBook(bookDto);
        return "redirect:/books";
    }


    @GetMapping("/{bookId}/edit")
    public String getEditBookPage(@PathVariable("bookId") long bookId, Model model){
        Book book = bookService.getBookEntityById(bookId);

        model.addAttribute("book", book);
        return "book/book-edit";
    }

    @PostMapping("/{bookId}/edit")
    public String postEditBook(@PathVariable("bookId") long bookId,
                               @ModelAttribute("book") Book book) {

        book.setId(bookId);
        bookService.editBookEntity(book);
        return "redirect:/books";
    }




}
