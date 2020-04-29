package api.services;

public interface PurchaseService {

    String NAME = "PurchaseService";

    int PORT = 1097;

    void addPurchase(Long bookId, Long clientId);

}
