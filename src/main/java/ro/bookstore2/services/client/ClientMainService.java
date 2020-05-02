package ro.bookstore2.services.client;

import org.springframework.stereotype.Service;
import ro.bookstore2.models.Client;

import java.util.List;

@Service
public class ClientMainService implements ClientService {
    @Override
    public Client getClientById(Long id) {
        return null;
    }

    @Override
    public void addClient(String firstName, String lastName, double moneySpent) {

    }

    @Override
    public void removeClient(Long id) {

    }

    @Override
    public void updateClient(Long id, String firstName, String lastName, double moneySpent) {

    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public List<Client> filterClientsByName(String name) {
        return null;
    }

    @Override
    public List<Client> topNClientsOnMoneySpent(int n) {
        return null;
    }
}
