package ro.bookstore2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.bookstore2.ui.Console;

public class AppClient {
    public static void main(String[] args) {
        System.out.println("start client app");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ro/bookstore2/config");

        context.getBean(Console.class).run();

        System.out.println("client stopped");
    }
}
