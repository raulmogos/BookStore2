package ro.bookstore2.services.purchase;

import org.springframework.stereotype.Service;
import ro.bookstore2.models.Purchase;

import java.util.List;

@Service
public class PurchaseMainService implements PurchaseService {

    @Override
    public Purchase getPurchaseById(Long id) {
        return null;
    }

    @Override
    public void addPurchase(Long bookId, Long clientId) {

    }

    @Override
    public void removePurchase(Long id) {

    }

    @Override
    public void updatePurchase(Long id, Long book_id, Long client_id) {

    }

    @Override
    public List<Purchase> getAllPurchases() {
        return null;
    }
}
