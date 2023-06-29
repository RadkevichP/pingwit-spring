package pl.pingwit.pingwitdemospring.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
@Configuration
public class DataSourceConfig {

    @Value("${db.url}")
    private String URL;
    @Value("${db.user}")
    private String USERNAME;
    @Value("${db.password}")
    private String PASSWORD;

    @Bean
    public DataSource createDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        return ds;
    }

}
