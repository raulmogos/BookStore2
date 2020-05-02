package ro.bookstore2.services;

import api.models.Book;
import api.models.validation.BookValidator;
import api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import ro.bookstore2.repository.book.BookRepository;

import java.util.ArrayList;

public class BookServerService implements BookService {

    private static final double NO_PRICE = -1.1;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookValidator bookValidator;


    @Override
    public Book getBookById(Long id) {
        return bookRepository.get(id).get();
    }

    @Override
    public void addBook(String title, String author, int price) {
        Book book = new Book(title, author, price);
        bookValidator.validate(book);
        bookRepository.save(book);
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public void updateBook(Long id, String title, String author, double price) {
        Book book = bookRepository.get(id).get();
        book.setTitle(!title.equals("") ? title : book.getTitle());
        book.setAuthor(!author.equals("") ? author : book.getAuthor());
        book.setPrice(price != NO_PRICE ? price : book.getPrice());
        bookRepository.update(book);
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.all();
    }

    @Override
    public Iterable<Book> filterBookAuthor(String author) {
        ArrayList<Book> filteredBooks = new ArrayList<>();
        bookRepository.all().forEach((book) -> {
            if (book.getAuthor().equals(author)) {
                filteredBooks.add(book);
            }
        });
        return filteredBooks;
    }

    @Override
    public Iterable<Book> filterBookPrice(double min, double max) {
        ArrayList<Book> filteredBooks = new ArrayList<>();
        bookRepository.all().forEach((book) -> {
            if (book.getPrice() >= min && book.getPrice() <= max) {
                filteredBooks.add(book);
            }
        });
        return filteredBooks;
    }
}
