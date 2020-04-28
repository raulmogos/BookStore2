package api.services;

import api.models.Book;

public interface BookService {

    String NAME = "BookService";

    Book getBookById(Long id);

    void addBook(String title, String author, int price);

    void removeBook(Long id);

    void updateBook(Long ID, String title, String author, int price);

    void allBooks();


    Iterable<Book> filterBookPrice(double min, double max);
}
