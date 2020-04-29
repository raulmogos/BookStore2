import api.services.BookService;
import api.services.ClientService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.Console;

public class AppClient {
    public static void main(String[] args) {
        System.out.println("start client app");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");

        context.getBean(Console.class).run();

        System.out.println("client stopped");
    }
}
