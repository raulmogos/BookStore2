package ro.bookstore2.services;

import api.models.Client;
import api.models.validation.ClientValidator;
import api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import ro.bookstore2.repository.client.ClientRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClientServerService implements ClientService {

    private static final double NO_MONEY = -1.1;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientValidator clientValidator;


    @Override
    public Client getClientById(Long id) {
        return clientRepository.get(id).get();
    }

    @Override
    public void addClient(String firstName, String lastName, double moneySpent) {
        Client client = new Client(firstName, lastName, moneySpent);
        clientValidator.validate(client);
        clientRepository.save(client);
    }

    @Override
    public void removeClient(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public void updateClient(Long id, String firstName, String lastName, double moneySpent) {
        Client client = clientRepository.get(id).get();
        client.setFirstName(!firstName.equals("") ? firstName : client.getFirstName());
        client.setLastName(!lastName.equals("") ? lastName : client.getLastName());
        client.setMoneySpent(moneySpent != NO_MONEY ? moneySpent : client.getMoneySpent());
        clientRepository.update(client);
    }

    @Override
    public Iterable<Client> getAllClients() {
        return clientRepository.all();
    }

    @Override
    public Iterable<Client> filterClientsByName(String name) {
        ArrayList<Client> filteredClients = new ArrayList<>();
        clientRepository.all().forEach((client) -> {
            if (client.getLastName().contains(name) || client.getFirstName().contains(name)) {
                filteredClients.add(client);
            }
        });
        return filteredClients;
    }

    @Override
    public Iterable<Client> topNClientsOnMoneySpent(int n) {
        return ((ArrayList<Client>) clientRepository.all()).stream()
                .sorted((Client client1, Client client2) -> (int) (- client1.getMoneySpent() + client2.getMoneySpent()))
                .limit(n)
                .collect(Collectors.toList());
    }
}
