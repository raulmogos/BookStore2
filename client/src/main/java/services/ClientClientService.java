package services;

import api.models.Client;
import api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientClientService implements ClientService {

    @Autowired
    ClientService clientServerService;

    @Override
    public Client getClientById(Long id) {
        return clientServerService.getClientById(id);
    }

    @Override
    public void addClient(String firstName, String lastName, double moneySpent) {
        clientServerService.addClient(firstName, lastName, moneySpent);
    }

    @Override
    public void removeClient(Long id) {
        clientServerService.removeClient(id);
    }

    @Override
    public void updateClient(Long id, String firstname, String lastname, double moneySpent) {
        clientServerService.updateClient(id, firstname, lastname, moneySpent);
    }

    @Override
    public Iterable<Client> getAllClients() {
        return clientServerService.getAllClients();
    }

    @Override
    public Iterable<Client> filterClientsByName(String name) {
        return clientServerService.filterClientsByName(name);
    }

    @Override
    public Iterable<Client> topNClientsOnMoneySpent(int n) {
        return clientServerService.topNClientsOnMoneySpent(n);
    }
}
