package services;

import api.models.Book;
import api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookClientService implements BookService {

    @Autowired
    BookService bookServerService;

    @Override
    public Book getBookById(Long id) {
        return bookServerService.getBookById(id);
    }

    @Override
    public void addBook(String title, String author, int price) {
        bookServerService.addBook(title, title, price);
    }

    @Override
    public void removeBook(Long id) {
        bookServerService.removeBook(id);
    }

    @Override
    public void updateBook(Long id, String title, String author, double price) {
        bookServerService.updateBook(id, title, author, price);
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookServerService.getAllBooks();
    }

    @Override
    public Iterable<Book> filterBookPrice(double min, double max) {
        return bookServerService.filterBookPrice(min, max);
    }
}
