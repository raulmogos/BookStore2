package services;

import api.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import repository.book.BookRepository;
import repository.client.ClientRepository;
import repository.purchase.PurchaseRepository;

public class PurchaseServerService implements PurchaseService {

    @Autowired BookRepository bookRepository;
    @Autowired ClientRepository clientRepository;
    @Autowired PurchaseRepository purchaseRepository;

    @Override
    public void addPurchase(Long bookId, Long clientId) {

    }
}
