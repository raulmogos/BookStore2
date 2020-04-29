package config;

import api.services.BookService;
import api.services.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import services.BookClientService;
import ui.Console;
import ui.UiBooks;

@Configuration
public class ClientConfig {

    // imported services

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

    // client services

    @Bean
    BookClientService bookClientService() {
        return new BookClientService();
    }

    // ui's

    @Bean
    UiBooks uiBooks() {
        return new UiBooks();
    }

    // console

    @Bean
    Console console() {
        return new Console();
    }

}
