package pl.pingwit.pingwitdemospring.lec_37.point_2;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Pavel Radkevich
 * @since 12.06.23
 */

public class DataSourceConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/pingwit_shop";
    private static final String USERNAME = "pingwit";
    private static final String PASSWORD = "pingwit_password";

    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        return ds;
    }
}
