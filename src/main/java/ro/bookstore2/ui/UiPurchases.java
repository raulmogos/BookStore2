package ro.bookstore2.ui;

import org.springframework.beans.factory.annotation.Autowired;
import ro.bookstore2.models.Purchase;
import ro.bookstore2.services.purchase.PurchaseService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UiPurchases {

    @Autowired
    private PurchaseService purchaseService;

    public void addPurchase() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book ID:");
            String bookID = reader.readLine();
            System.out.println("Client ID:");
            String clientID = reader.readLine();
            this.purchaseService.addPurchase(new Purchase(Long.parseLong(bookID), Long.parseLong(clientID)));
            System.out.println("Purchase added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printPurchases() {
        this.purchaseService.getAllPurchases().forEach(System.out::println);
    }

    public void deletePurchase() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Purchase ID:");
            String ID = reader.readLine();
            this.purchaseService.removePurchase(Long.parseLong(ID));
            System.out.println("Purchase deleted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
