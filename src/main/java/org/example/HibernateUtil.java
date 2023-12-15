package org.example;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234567890A12";

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil(){



        this.sessionFactory = new Configuration()
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/postgres")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "1234567890A12")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

        flywayMigration();
    }

    public static HibernateUtil getInstance(){
        return INSTANCE;
    }
    public SessionFactory getSessionFactory(){
        return  this.sessionFactory;
    }
    public void closeSessionFactory(){
        this.sessionFactory.close();
    }
    private void flywayMigration(){
        Flyway flyway = Flyway.configure().dataSource(URL,USER,PASSWORD).load();
        flyway.migrate();
    }
}
