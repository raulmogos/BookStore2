import api.services.BookService;
import config.ClientConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppClient {
    public static void main(String[] args) {
        System.out.println("start client app");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");

        BookService bookService = (BookService) context.getBean(BookService.class);
        System.out.println(bookService.getBookById(1L));

        System.out.println("client stopped");
    }
}
