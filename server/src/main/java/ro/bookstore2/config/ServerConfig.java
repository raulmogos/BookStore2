package ro.bookstore2.config;

import api.models.validation.BookValidator;
import api.models.validation.ClientValidator;
import api.models.validation.PurchaseValidator;
import api.services.BookService;
import api.services.ClientService;

import api.services.PurchaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import ro.bookstore2.repository.book.BookRepository;
import ro.bookstore2.repository.book.BookRepositoryJdbc;
import ro.bookstore2.repository.client.ClientRepository;
import ro.bookstore2.repository.client.ClientRepositoryJdbc;
import ro.bookstore2.repository.purchase.PurchaseRepository;
import ro.bookstore2.repository.purchase.PurchaseRepositoryJdbc;
import ro.bookstore2.services.BookServerService;
import ro.bookstore2.services.ClientServerService;
import ro.bookstore2.services.PurchaseServerService;

@Configuration
public class ServerConfig {

    // exported ro.bookstore2.services

    @Bean
    RmiServiceExporter rmiBookServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(BookService.NAME);
        rmiServiceExporter.setServiceInterface(BookService.class);
        rmiServiceExporter.setService(bookService());
        rmiServiceExporter.setRegistryPort(BookService.PORT);
        return rmiServiceExporter;
    }

    @Bean
    RmiServiceExporter rmiClientServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(ClientService.NAME);
        rmiServiceExporter.setServiceInterface(ClientService.class);
        rmiServiceExporter.setService(clientService());
        rmiServiceExporter.setRegistryPort(ClientService.PORT);
        return rmiServiceExporter;
    }

    @Bean
    RmiServiceExporter rmiPurchaseServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(PurchaseService.NAME);
        rmiServiceExporter.setServiceInterface(PurchaseService.class);
        rmiServiceExporter.setService(purchaseService());
        rmiServiceExporter.setRegistryPort(PurchaseService.PORT);
        return rmiServiceExporter;
    }

    // implemented ro.bookstore2.services

    @Bean
    BookService bookService() {
        return new BookServerService();
    }

    @Bean
    ClientService clientService() {
        return new ClientServerService();
    }

    @Bean
    PurchaseService purchaseService() {
        return new PurchaseServerService();
    }


    // ro.bookstore2.repositories

    @Bean
    BookRepository bookRepository() {
        return new BookRepositoryJdbc();
    }

    @Bean
    ClientRepository clientRepository() {
        return new ClientRepositoryJdbc();
    }

    @Bean
    PurchaseRepository purchaseRepository() {
        return new PurchaseRepositoryJdbc();
    }


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
}
