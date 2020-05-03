package ro.bookstore2.services.purchase;

import ro.bookstore2.models.Purchase;

import java.util.List;

public interface PurchaseService {

    String NAME = "PurchaseService";

    Purchase getPurchaseById(Long id);

    void addPurchase(Purchase purchase);

    void removePurchase(Long id);

    void updatePurchase(Purchase newPurchase);

    List<Purchase> getAllPurchases();
}
