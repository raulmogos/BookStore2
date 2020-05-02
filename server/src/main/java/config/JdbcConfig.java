package config;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    JdbcOperations jdbcOperations() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(Dotenv.load().get("DB_URL"));
        basicDataSource.setUsername(Dotenv.load().get("DB_USERNAME"));
        basicDataSource.setPassword(Dotenv.load().get("DB_PASSWORD"));
        basicDataSource.setInitialSize(2);  // Sets the initial size of the connection pool.
        return basicDataSource;
    }
}
