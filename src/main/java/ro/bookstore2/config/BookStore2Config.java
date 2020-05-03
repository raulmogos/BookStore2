package ro.bookstore2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ro.bookstore2.models.validation.BookValidator;
import ro.bookstore2.models.validation.ClientValidator;
import ro.bookstore2.models.validation.PurchaseValidator;
import ro.bookstore2.ui.Console;
import ro.bookstore2.ui.UiBooks;
import ro.bookstore2.ui.UiClients;
import ro.bookstore2.ui.UiPurchases;

@Configuration
@ComponentScan({"ro.bookstore2.repositories", "ro.bookstore2.services", "ro.bookstore2.ui"})
public class BookStore2Config {

    // validators

    @Bean
    BookValidator bookValidator() {
        return new BookValidator();
    }

    @Bean
    ClientValidator clientValidator() {
        return new ClientValidator();
    }

    @Bean
    PurchaseValidator purchaseValidator() {
        return new PurchaseValidator();
    }

    //ui's

    @Bean
    public UiBooks uiBooks() {
        return new UiBooks();
    }

    @Bean
    public UiClients uiClients() { return new UiClients(); }

    @Bean
    public UiPurchases uiPurchases() { return new UiPurchases(); }

    // console

    @Bean
    public Console console() {
        return new Console();
    }
}
