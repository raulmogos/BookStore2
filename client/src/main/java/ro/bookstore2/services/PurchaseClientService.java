package ro.bookstore2.services;

import api.models.Purchase;
import api.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseClientService implements PurchaseService {

    @Autowired
    PurchaseService purchaseServerService;

    @Override
    public Purchase getPurchaseById(Long id) {
        return purchaseServerService.getPurchaseById(id);
    }

    @Override
    public void addPurchase(Long bookId, Long clientId) {
        purchaseServerService.addPurchase(bookId, clientId);
    }

    @Override
    public void removePurchase(Long id) {
        purchaseServerService.removePurchase(id);
    }

    @Override
    public void updatePurchase(Long id, Long book_id, Long client_id) {
        purchaseServerService.updatePurchase(id, book_id, client_id);
    }

    @Override
    public Iterable<Purchase> getAllPurchases() {
        return purchaseServerService.getAllPurchases();
    }
}
