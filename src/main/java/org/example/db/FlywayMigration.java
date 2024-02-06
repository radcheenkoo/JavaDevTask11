package org.example.db;

import org.flywaydb.core.Flyway;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FlywayMigration {
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234567890A12";
    private FlywayMigration(){}

    public static void migrating(){
        Flyway.configure().dataSource(URL, USER, PASSWORD)
                .baselineOnMigrate(true)
                .locations("classpath:db.migration")
                .load().migrate();

    }
}
