package api.services;

import api.models.Client;

public interface ClientService {

    String NAME = "ClientService";

    int PORT = 1098;

    void addClient(String firstName, String lastName, double moneySpent);

    Iterable<Client> getAllClients();
}