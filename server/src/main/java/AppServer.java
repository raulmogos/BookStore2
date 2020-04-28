import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.book.BookRepository;


public class AppServer {
    public static void main(String[] args) {
        System.out.println("server started");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");

    }
}
