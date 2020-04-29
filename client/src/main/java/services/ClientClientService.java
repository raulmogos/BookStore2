package services;

import api.models.Client;
import api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientClientService implements ClientService {

    @Autowired
    ClientService clientService;

    @Override
    public void addClient(String firstName, String lastName, double moneySpent) {

    }

    @Override
    public Iterable<Client> getAllClients() {
        return clientService.getAllClients();
    }
}
