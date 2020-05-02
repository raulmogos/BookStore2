package ro.bookstore2.config;

import api.services.BookService;
import api.services.ClientService;
import api.services.PurchaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ro.bookstore2.services.BookClientService;
import ro.bookstore2.services.ClientClientService;
import ro.bookstore2.services.PurchaseClientService;
import ro.bookstore2.ui.Console;
import ro.bookstore2.ui.UiBooks;
import ro.bookstore2.ui.UiClients;
import ro.bookstore2.ui.UiPurchases;

@Configuration
public class ClientConfig {

    // imported ro.bookstore2.services

    @Bean
    RmiProxyFactoryBean rmiBookServiceProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(BookService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:" + BookService.PORT + "/" + BookService.NAME);
        return rmiProxyFactoryBean;
    }

    @Bean
    RmiProxyFactoryBean rmiClientServiceProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(ClientService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:" + ClientService.PORT + "/" + ClientService.NAME);
        return rmiProxyFactoryBean;
    }

    @Bean
    RmiProxyFactoryBean rmiPurchaseServiceProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(PurchaseService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:" + PurchaseService.PORT + "/" + PurchaseService.NAME);
        return rmiProxyFactoryBean;
    }

    // client ro.bookstore2.services

    @Bean
    BookClientService bookClientService() {
        return new BookClientService();
    }

    @Bean
    ClientClientService clientClientService() {
        return new ClientClientService();
    }

    @Bean
    PurchaseClientService purchaseClientService() {
        return new PurchaseClientService();
    }

    // ro.bookstore2.ui's

    @Bean
    UiBooks uiBooks() {
        return new UiBooks();
    }

    @Bean
    UiClients uiClients() {
        return new UiClients();
    }

    @Bean
    UiPurchases uiPurchases() {
        return new UiPurchases();
    }

    // console

    @Bean
    Console console() {
        return new Console();
    }

}
