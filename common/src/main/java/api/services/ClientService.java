package api.services;

import api.models.Client;

public interface ClientService {

    String NAME = "ClientService";

    int PORT = 1098;

    Client getClientById(Long id);

    void addClient(String firstName, String lastName, double moneySpent);

    void removeClient(Long id);

    void updateClient(Long id, String firstName, String lastName, double moneySpent);

    Iterable<Client> getAllClients();

    Iterable<Client> filterClientsByName(String name);

    Iterable<Client> topNClientsOnMoneySpent(int n);
}