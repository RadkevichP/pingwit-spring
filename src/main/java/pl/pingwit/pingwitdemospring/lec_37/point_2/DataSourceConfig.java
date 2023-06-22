package pl.pingwit.pingwitdemospring.lec_37.point_2;


/**
 * @author Pavel Radkevich
 * @since 12.06.23
 */

public class DataSourceConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/pingwit_shop";
    private static final String USERNAME = "pingwit";
    private static final String PASSWORD = "pingwit_password";

  /*  @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        return ds;
    }*/
}
