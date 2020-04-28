package api.services;

public interface PurchaseService {

    String NAME = "PurchaseService";

    void addPurchase(Long bookId, Long clientId);

}
