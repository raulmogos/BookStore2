package ro.bookstore2.repository.book;

import api.models.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.Optional;


public class BookRepositoryJdbc implements BookRepository {


    @Autowired
    private JdbcOperations jdbcOperations;


    @Override
    public Optional<Book> get(Long id) {
        String sql = "select * from books where id = ?";
        Book book = jdbcOperations.queryForObject(sql, new Object[] { id }, new BookRowMapper());
        return Optional.ofNullable(book);
    }


    @Override
    public Iterable<Book> all() {
        return jdbcOperations.query("select * from books", new BookRowMapper());
    }


    @Override
    public Iterable<Book> chunk(Long startId, Long size) {
        String query = "select * from books where id > ? limit ?";
        return jdbcOperations.query(query, new Object[] { startId, size },new BookRowMapper());
    }


    @Override
    public Optional<Book> save(Book book) {
        String query = "insert into books (title, author, price) values (?,?,?)";
        jdbcOperations.update(query, book.getTitle(), book.getAuthor(), book.getPrice());
        book.setId(this.getMaxId());
        return Optional.of(book);
    }


    @Override
    public Optional<Book> delete(Long id) {
        String sql = "select * from books where id = ?";
        Book book = jdbcOperations.queryForObject(sql, new Object[] { id }, new BookRowMapper());
        jdbcOperations.update("delete from books where id=?", id);
        return Optional.ofNullable(book);
    }


    @Override
    public Optional<Book> update(Book book) {
        String sql = "update books set title=?, author=?, price=? where id=?";
        jdbcOperations.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getId());
        return Optional.of(book);
    }


    protected Long getMaxId() {
        return jdbcOperations.queryForObject("select id from books order by id desc limit 1", Long.class);
    }



    protected static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(@NotNull ResultSet resultSet, int rowNum) {
            try {
                return new Book(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getDouble("price")
                );
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
