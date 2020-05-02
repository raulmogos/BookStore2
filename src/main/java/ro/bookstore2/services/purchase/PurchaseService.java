package ro.bookstore2.services.purchase;

import ro.bookstore2.models.Purchase;

import java.util.List;

public interface PurchaseService {

    String NAME = "PurchaseService";

    Purchase getPurchaseById(Long id);

    void addPurchase(Long bookId, Long clientId);

    void removePurchase(Long id);

    void updatePurchase(Long id, Long book_id, Long client_id);

    List<Purchase> getAllPurchases();
}
