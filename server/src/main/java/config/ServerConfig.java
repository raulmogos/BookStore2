package config;

import api.services.BookService;
import api.services.ClientService;

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

    @Bean
    RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();

        rmiServiceExporter.setServiceName("BookService");
        rmiServiceExporter.setServiceInterface(BookService.class);
        rmiServiceExporter.setService(bookService());

//        rmiServiceExporter.setServiceName("ClientService");
//        rmiServiceExporter.setServiceInterface(ClientService.class);
//        rmiServiceExporter.setService(clientService());
//
//        rmiServiceExporter.setServiceName("PurchaseService");
//        rmiServiceExporter.setServiceInterface(ClientService.class);
//        rmiServiceExporter.setService(clientService());

        rmiServiceExporter.setRegistryPort(1099);

        return rmiServiceExporter;
    }

    // services

    @Bean
    BookService bookService() {
        return new BookServerService();
    }

    @Bean
    ClientServerService clientService() {
        return new ClientServerService();
    }

    @Bean
    PurchaseServerService purchaseService() {
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


}
