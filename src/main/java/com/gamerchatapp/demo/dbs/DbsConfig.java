package com.gamerchatapp.demo.dbs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbsConfig {
    private final String url;
    private final String driver;
    private final String username;
    private final String password;

    public DbsConfig(@Value("${management.dbs.path}") String url,
                     @Value("${management.dbs.user}") String user,
                     @Value("${management.dbs.pass}") String pass,
                     @Value("${management.dbs.driver}") String driver) {
        this.url = url;
        this.driver = driver;
        this.username = user;
        this.password = pass;
    }

    @Bean(name="db_datasource")
    public DataSource getDataSourceConfig() {
        return DataSourceBuilder
                .create()
                .driverClassName(driver)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean(name="master_jdbc")
    public JdbcTemplate getJDBC(@Qualifier("db_datasource") DataSource dbDataSource) {
        return new JdbcTemplate(dbDataSource);
    }
}
