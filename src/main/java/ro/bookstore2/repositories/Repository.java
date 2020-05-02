package ro.bookstore2.repositories;

import ro.bookstore2.models.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface Repository
        <T extends BaseEntity<ID>,ID extends Serializable>
        extends JpaRepository<T, ID>
{

}
