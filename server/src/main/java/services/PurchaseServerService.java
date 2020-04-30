package services;

import api.models.Purchase;
import api.models.validation.PurchaseValidator;
import api.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import repository.book.BookRepository;
import repository.client.ClientRepository;
import repository.purchase.PurchaseRepository;

public class PurchaseServerService implements PurchaseService {

    private static final double NO_ID = -1.1;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    PurchaseValidator purchaseValidator;

    @Override
    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.get(id).get();
    }

    @Override
    public void addPurchase(Long bookId, Long clientId) {
        // todo: validate bookId and clientId
        Purchase purchase = new Purchase(bookId, clientId);
        purchaseValidator.validate(purchase);
        purchaseRepository.save(purchase);
    }

    @Override
    public void removePurchase(Long id) {
        purchaseRepository.delete(id);
    }

    @Override
    public void updatePurchase(Long id, Long book_id, Long client_id) {
        Purchase purchase = new Purchase(id, book_id, client_id);
        purchase.setBookId(book_id != NO_ID ? book_id : purchase.getBookId());
        purchase.setClientId(client_id != NO_ID ? client_id : purchase.getClientId());
        purchaseRepository.update(purchase);
    }

    @Override
    public Iterable<Purchase> getAllPurchases() {
        return purchaseRepository.all();
    }
}
