package ro.bookstore2.ui;

import org.springframework.beans.factory.annotation.Autowired;
import ro.bookstore2.models.Book;
import ro.bookstore2.services.book.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UiBooks {

    @Autowired
    private BookService bookService;

    public void addBook() {
        String title, author, price;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book Title:");
            title = reader.readLine();
            System.out.println("Book Author:");
            author = reader.readLine();
            System.out.println("Book Price:");
            price = reader.readLine();
            this.bookService.addBook(new Book(title, author, Integer.parseInt(price)));
            System.out.println("Successfully added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printBooks() {
        Iterable<Book> books = this.bookService.getAllBooks();
        books.forEach(System.out::println);
    }

    public void updateBook() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book ID:");
            String id = reader.readLine();
            System.out.println("New Book Title (Blank if unchanged):");
            String title = reader.readLine();
            System.out.println("New Book Author (Blank if unchanged):");
            String author = reader.readLine();
            System.out.println("New Book Price (Blank if unchanged):");
            String price = reader.readLine();
            this.bookService.updateBook(new Book(Long.parseLong(id), title, author, Long.parseLong(price)));
            System.out.println("Updated successfully !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book id:");
            String id = reader.readLine();
            this.bookService.removeBook(Long.parseLong(id));
            System.out.println("Book deleted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterBooksAuthor() {
        String author;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book Author:");
            author = reader.readLine();
            Iterable<Book> books = this.bookService.filterBookAuthor(author);
            books.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterBooksPrice() {
        String minPrice, maxPrice;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Minimum Price:");
            minPrice = reader.readLine();
            System.out.println("Maximum Price:");
            maxPrice = reader.readLine();
            Iterable<Book> books = this.bookService.filterBookPrice(Integer.parseInt(minPrice), Integer.parseInt(maxPrice));
            books.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
