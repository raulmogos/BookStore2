package repository.book;

import api.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.sql.ResultSet;
import java.util.Optional;

public class BookRepositoryJdbc implements BookRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public Optional<Book> find(Long id) {
        String sql = "select * from books where id = ?";
        return jdbcOperations.queryForObject(sql, new Object[] { id }, (ResultSet resultSet, int rowNum) -> {
            return Optional.of(new Book(
                resultSet.getLong("id"),
                resultSet.getString("title"),
                resultSet.getString("author"),
                resultSet.getDouble("price")
            ));
        });
    }

    @Override
    public Iterable<Book> all() {
        return null;
    }

    @Override
    public Iterable<Book> chunk(Long startId, Long size) {
        return null;
    }

    @Override
    public Optional<Book> save(Book book) {
        String sql = "insert into books (title, author, price) values (?,?,?)";
        jdbcOperations.update(sql, book.getTitle(), book.getAuthor(), book.getPrice());
        //
        sql = "select * from books where id = ?";
//        SELECT * FROM books ORDER BY my_id DESC LIMIT 1

        return Optional.empty();
    }

    @Override
    public Optional<Book> delete(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> update(Book entity) {
        return Optional.empty();
    }

    private Long getMaxId() {
        // todo
        return 1L;
    }
}
