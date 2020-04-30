package ui;

import api.models.Purchase;
import api.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UiPurchases {

    @Autowired
    private PurchaseService purchaseClientService;

    public void addPurchase() {
        String bookID, clientID;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book ID:");
            bookID = reader.readLine();
            System.out.println("Client ID:");
            clientID = reader.readLine();
            this.purchaseClientService.addPurchase(Long.parseLong(bookID), Long.parseLong(clientID));
            System.out.println("Purchase added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printPurchases() {
        Iterable<Purchase> purchases = this.purchaseClientService.getAllPurchases();
        purchases.forEach(System.out::println);
    }

    public void deletePurchase() {
        String ID;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Purchase ID:");
            ID = reader.readLine();
            this.purchaseClientService.removePurchase(Long.parseLong(ID));
            System.out.println("Purchase deleted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
