package services;

import api.models.Book;
import api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BookClientService implements BookService {

    @Autowired
    BookService bookService;

    @Override
    public Book getBookById(Long id) {
        return bookService.getBookById(id);
    }

    @Override
    public void addBook(String title, String author, int price) {
        bookService.addBook("asda", "Asdasd", 23);
    }
}
