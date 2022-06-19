package com.meli.dna.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
//@Component
public class DataSourceConfig {
//
//    static final Logger LOGGER = Logger.getLogger("Log Conexion");
//
//
//    @Primary
//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() throws SQLException, InterruptedException {
//
//        try {
//            DataSource dataSource = DataSourceBuilder.create().driverClassName("org.mariadb.jdbc.Driver") // install
//                    /**mariadb
//                     /* into pom
//                     /*file**/
//                    .url("jdbc:mariadb://" +
//                            + "/enrollment")
//                    .username(secretManagementClient.getSpecificData(dataSecret, "user_db"))
//                    .password(secretManagementClient.getSpecificData(dataSecret, "password_db")).build();
//
//            dataSource.getConnection();
//            return dataSource;
//
//        } catch (SQLException exc) {
//            LOGGER.log(Level.INFO, "reconnecting in 3 seconds");
//            INTENTOS++;
//
//            if (INTENTOS > 3) {
//                LOGGER.log(Level.INFO, "Se superó el número de intentos de reconexión : " , exc.getMessage());
//                Thread.currentThread().interrupt();
//                throw new InterruptedException("No se ha establecido conexion con la BD");
//            } else {
//                LOGGER.log(Level.INFO, "Intento de conexion :" , INTENTOS);
//                Thread.sleep(SLEEP_TO_RECONNECT);
//            }
//            return dataSource();
//        }
//
//    }

}
