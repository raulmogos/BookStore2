package api.services;

import api.models.Purchase;

public interface PurchaseService {

    String NAME = "PurchaseService";

    int PORT = 1097;

    Purchase getPurchaseById(Long id);

    void addPurchase(Long bookId, Long clientId);

    void removePurchase(Long id);

    void updatePurchase(Long id, Long book_id, Long client_id);

    Iterable<Purchase> getAllPurchases();
}
