package ro.bookstore2.repository;

import api.models.BaseEntity;

import java.util.Optional;

public interface Repository<ID, T extends BaseEntity<ID>> {

    Optional<T> get(ID id);

    Iterable<T> all();

    Iterable<T> chunk(Long startId, Long size);

    Optional<T> save(T entity);

    Optional<T> delete(ID id);

    Optional<T> update(T entity);
}
