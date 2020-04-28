package services;

import api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import repository.client.ClientRepository;

public class ClientServerService implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void addClient(String firstName, String lastName) {

    }
}
