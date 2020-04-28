package repository.client;

import api.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Optional;

public class ClientRepositoryJdbc implements ClientRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public Optional<Client> find(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Client> all() {
        return null;
    }

    @Override
    public Iterable<Client> chunk(Long startId, Long size) {
        return null;
    }

    @Override
    public Optional<Client> save(Client entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> delete(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> update(Client entity) {
        return Optional.empty();
    }
}
