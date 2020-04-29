package ui;

import api.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import services.BookClientService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UiBooks {

    @Autowired
    private BookClientService bookClientService;

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
            this.bookClientService.addBook(title, author, Integer.parseInt(price));
            System.out.println("Successfully added!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printBooks() {
        Iterable<Book> books = this.bookClientService.getAllBooks();
        books.forEach(System.out::println);
    }

    public void updateBook() {
        String ID, title, author, price;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book ID:");
            ID = reader.readLine();
            System.out.println("New Book Title (Blank if unchanged):");
            title = reader.readLine();
            System.out.println("New Book Author (Blank if unchanged):");
            author = reader.readLine();
            System.out.println("New Book Price (Blank if unchanged):");
            price = reader.readLine();
            this.bookClientService.updateBook(Long.parseLong(ID), title, author, Long.parseLong(price));
            System.out.println("Updated successfully !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book id:");
            String id = reader.readLine();
            this.bookClientService.removeBook(Long.parseLong(id));
            System.out.println("Book deleted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
