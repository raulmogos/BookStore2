package ro.bookstore2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.bookstore2.ui.Console;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello BookStore2");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ro.bookstore2");

        context.getBean(Console.class).run();

        System.out.println("bye BookStore2");
    }
}
