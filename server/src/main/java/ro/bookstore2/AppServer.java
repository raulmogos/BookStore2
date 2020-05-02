package ro.bookstore2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppServer {
    public static void main(String[] args) {
        System.out.println("server started");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ro/bookstore2/config");

    }
}
