package config;

import api.models.validation.BookValidator;
import api.models.validation.ClientValidator;
import api.models.validation.PurchaseValidator;
import api.services.BookService;
import api.services.ClientService;

import api.services.PurchaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import repository.book.BookRepository;
import repository.book.BookRepositoryJdbc;
import repository.client.ClientRepository;
import repository.client.ClientRepositoryJdbc;
import repository.purchase.PurchaseRepository;
import repository.purchase.PurchaseRepositoryJdbc;
import services.BookServerService;
import services.ClientServerService;
import services.PurchaseServerService;

@Configuration
public class ServerConfig {

    // exported services

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

    // implemented services

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


    // repositories

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
