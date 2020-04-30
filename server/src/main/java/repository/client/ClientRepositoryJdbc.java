package repository.client;

import api.models.Client;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.Optional;

public class ClientRepositoryJdbc implements ClientRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public Optional<Client> get(Long id) {
        String sql = "select * from clients where id = ?";
        Client client = jdbcOperations.queryForObject(sql, new Object[] { id }, new ClientRowMapper());
        return Optional.ofNullable(client);
    }

    @Override
    public Iterable<Client> all() {
        return jdbcOperations.query("select * from clients", new ClientRowMapper());
    }

    @Override
    public Iterable<Client> chunk(Long startId, Long size) {
        String query = "select * from clients where id > ? limit ?";
        return jdbcOperations.query(query, new Object[] { startId, size}, new ClientRowMapper());
    }

    @Override
    public Optional<Client> save(Client client) {
        String query = "insert into clients (first_name, last_name, money_spent) values (?, ?, ?)";
        jdbcOperations.update(query, client.getFirstName(), client.getLastName(), client.getMoneySpent());
        client.setId(this.getMaxId());
        return Optional.of(client);
    }

    @Override
    public Optional<Client> delete(Long id) {
        String sql = "select * from clients where id = ?";
        Client client = jdbcOperations.queryForObject(sql, new Object[] { id }, new ClientRowMapper());
        jdbcOperations.update("delete from clients where id=?", id);
        return Optional.ofNullable(client);
    }

    @Override
    public Optional<Client> update(Client client) {
        String sql = "update clients set first_name=?, last_name=?, money_spent=? where id=?";
        jdbcOperations.update(sql, client.getFirstName(), client.getLastName(), client.getMoneySpent(), client.getId());
        return Optional.of(client);
    }

    protected Long getMaxId() {
        return jdbcOperations.queryForObject("select id from clients order by id desc limit 1", Long.class);
    }

    protected static class ClientRowMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(@NotNull ResultSet resultSet, int rowNum) {
            try {
                return new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDouble("money_spent")
                );
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
