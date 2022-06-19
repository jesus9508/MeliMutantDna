package com.meli.dna.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@Component
public class DataSourceConfig {

    static final Logger LOGGER = Logger.getLogger("Log Conexion");
    static final String USER = "admin";
    static final String PASS = "melidna123";
    static final String HOST = "database-dna.ccyoyffl7r1w.us-east-1.rds.amazonaws.com";


    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws SQLException, InterruptedException {

        try {
            DataSource dataSource = DataSourceBuilder.create().driverClassName("org.mariadb.jdbc.Driver")
                    .url("jdbc:mariadb://"+HOST+"/dna")
                    .username(USER)
                    .password(PASS).build();

            dataSource.getConnection();
            LOGGER.log(Level.INFO, "connection to rds db successfull");
            return dataSource;

        } catch (SQLException exc) {
            LOGGER.log(Level.INFO, "Failed connection to rds db");
            return null;
        }

    }

}
