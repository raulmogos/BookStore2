package ro.bookstore2.services.book;

import ro.bookstore2.models.Book;

import java.util.List;

public interface BookService {

    String NAME = "BookService";

    Book getBookById(Long id);

    void addBook(Book book);

    void removeBook(Long id);

    void updateBook(Book book);

    List<Book> getAllBooks();

    List<Book> filterBookAuthor(String author);

    List<Book> filterBookPrice(double min, double max);
}
