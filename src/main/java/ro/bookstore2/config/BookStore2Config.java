package ro.bookstore2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ro.bookstore2.models.validation.BookValidator;
import ro.bookstore2.ui.Console;
import ro.bookstore2.ui.UiBooks;

@Configuration
@ComponentScan({"ro.bookstore2.repositories", "ro.bookstore2.services", "ro.bookstore2.ui"})
public class BookStore2Config {

    // validators

    @Bean
    BookValidator bookValidator() {
        return new BookValidator();
    }

    //ui's

    @Bean
    public UiBooks uiBooks() {
        return new UiBooks();
    }

    // console

    @Bean
    public Console console() {
        return new Console();
    }
}
