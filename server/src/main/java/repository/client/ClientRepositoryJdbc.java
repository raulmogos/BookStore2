package repository.client;

import api.models.Book;
import api.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.sql.ResultSet;
import java.util.Optional;

public class ClientRepositoryJdbc implements ClientRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public Optional<Client> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Client> all() {
        String sql = "select * from clients";
        return jdbcOperations.query(sql, (ResultSet resultSet, int rowNum) ->
                new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDouble("money_spent")
                )
        );
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
