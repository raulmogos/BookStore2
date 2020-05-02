package ro.bookstore2.repository.purchase;

import api.models.Purchase;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.Optional;

public class PurchaseRepositoryJdbc implements PurchaseRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public Optional<Purchase> get(Long id) {
        String sql = "select * from purchases where id = ?";
        Purchase purchase = jdbcOperations.queryForObject(sql, new Object[] { id }, new PurchaseRowMapper());
        return Optional.ofNullable(purchase);
    }

    @Override
    public Iterable<Purchase> all() {
        return jdbcOperations.query("select * from purchases", new PurchaseRowMapper());
    }

    @Override
    public Iterable<Purchase> chunk(Long startId, Long size) {
        String query = "select * from purchases where id > ? limit ?";
        return jdbcOperations.query(query, new Object[] { startId, size },new PurchaseRowMapper());
    }

    @Override
    public Optional<Purchase> save(Purchase purchase) {
        String query = "insert into purchases (book_id, client_id) values (?,?)";
        jdbcOperations.update(query, purchase.getBookId(), purchase.getClientId());
        purchase.setId(this.getMaxId());
        return Optional.of(purchase);
    }

    @Override
    public Optional<Purchase> delete(Long id) {
        String sql = "select * from purchases where id = ?";
        Purchase purchase = jdbcOperations.queryForObject(sql, new Object[] { id }, new PurchaseRowMapper());
        jdbcOperations.update("delete from purchases where id=?", id);
        return Optional.ofNullable(purchase);
    }

    @Override
    public Optional<Purchase> update(Purchase purchase) {
        String sql = "update purchases set book_id=?, client_id=? where id=?";
        jdbcOperations.update(sql, purchase.getBookId(), purchase.getClientId(), purchase.getId());
        return Optional.of(purchase);
    }

    protected Long getMaxId() {
        return jdbcOperations.queryForObject("select id from purchases order by id desc limit 1", Long.class);
    }

    protected static class PurchaseRowMapper implements RowMapper<Purchase> {
        @Override
        public Purchase mapRow(@NotNull ResultSet resultSet, int rowNum) {
            try {
                return new Purchase(
                        resultSet.getLong("id"),
                        resultSet.getLong("book_id"),
                        resultSet.getLong("client_id")
                );
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
