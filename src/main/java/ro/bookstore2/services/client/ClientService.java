package ro.bookstore2.services.client;

import ro.bookstore2.models.Client;

import java.util.List;

public interface ClientService {

    String NAME = "ClientService";

    Client getClientById(Long id);

    void addClient(String firstName, String lastName, double moneySpent);

    void removeClient(Long id);

    void updateClient(Long id, String firstName, String lastName, double moneySpent);

    List<Client> getAllClients();

    List<Client> filterClientsByName(String name);

    List<Client> topNClientsOnMoneySpent(int n);
}