package ro.bookstore2.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({JPAConfig.class})
// todo: ask if we can use .env
@PropertySources({@PropertySource(value = "classpath:local/db.properties"),})
public class AppLocalConfig {

    /**
     * Enables placeholders usage with SpEL expressions.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
