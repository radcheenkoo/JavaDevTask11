package org.example.db;

import org.apache.logging.log4j.*;
import org.flywaydb.core.Flyway;

public class FlywayMigration {
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234567890A12";
    private static final Logger LOG = LogManager.getLogger(FlywayMigration.class);
    private FlywayMigration(){}

    public static void migrating(){
        Flyway.configure().dataSource(URL, USER, PASSWORD)
                .baselineOnMigrate(true)
                .load().migrate();
        LOG.info("Mіграція завершена");
    }
}
