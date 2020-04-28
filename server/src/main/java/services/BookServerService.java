package services;

import api.models.Book;
import api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import repository.book.BookRepository;

import java.util.Optional;

public class BookServerService implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        return bookRepository.find(id).get();
    }

    @Override
    public void addBook(String title, String author, int price) {
        // todo: validate it
        bookRepository.save(new Book(title, author, price));
    }

    @Override
    public void removeBook(Long id) {

    }

    @Override
    public void updateBook(Long ID, String title, String author, int price) {

    }

    @Override
    public void allBooks() {

    }

    @Override
    public Iterable<Book> filterBookPrice(double min, double max) {
        return null;
    }
}
