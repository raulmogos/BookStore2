package api.services;

import api.models.Book;

public interface BookService {

    String NAME = "BookService";

    int PORT = 1099;

    Book getBookById(Long id);

    void addBook(String title, String author, int price);

    void removeBook(Long id);

    void updateBook(Long id, String title, String author, double price);

    Iterable<Book> getAllBooks();

    Iterable<Book> filterBookPrice(double min, double max);
}
