package repository.purchase;

import api.models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Optional;

public class PurchaseRepositoryJdbc implements PurchaseRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public Optional<Purchase> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Purchase> all() {
        return null;
    }

    @Override
    public Iterable<Purchase> chunk(Long startId, Long size) {
        return null;
    }

    @Override
    public Optional<Purchase> save(Purchase entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Purchase> delete(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Purchase> update(Purchase entity) {
        return Optional.empty();
    }
}
