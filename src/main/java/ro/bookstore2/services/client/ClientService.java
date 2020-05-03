package ro.bookstore2.services.client;

import ro.bookstore2.models.Client;

import java.util.List;

public interface ClientService {

    String NAME = "ClientService";

    Client getClientById(Long id);

    void addClient(Client client);

    void removeClient(Long id);

    void updateClient(Client client);

    List<Client> getAllClients();

    List<Client> filterClientsByName(String name);

    List<Client> topNClientsOnMoneySpent(int n);
}